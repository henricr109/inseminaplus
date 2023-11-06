package com.inseminaplus.spring.security.mongodb.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.inseminaplus.spring.security.mongodb.models.*;
import com.inseminaplus.spring.security.mongodb.payload.request.LoginRequest;
import com.inseminaplus.spring.security.mongodb.payload.request.SignupRequest;
import com.inseminaplus.spring.security.mongodb.payload.response.MessageResponse;
import com.inseminaplus.spring.security.mongodb.payload.response.JwtResponse;
import com.inseminaplus.spring.security.mongodb.repository.RoleRepository;
import com.inseminaplus.spring.security.mongodb.security.jwt.JwtUtils;
import com.inseminaplus.spring.security.mongodb.security.services.UserDetailsImpl;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.inseminaplus.spring.security.mongodb.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
  }
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
    User user = new User(signUpRequest.getUsername(),
                         signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword()),
            signUpRequest.getBirthDate(),
            signUpRequest.getAddress(),
            signUpRequest.getCertificateCode());

    Set<String> strRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_COMPRADOR)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "vendedor":
          Role vendedorRole = roleRepository.findByName(ERole.ROLE_VENDEDOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(vendedorRole);

          break;
        default:
          Role compradorRole = roleRepository.findByName(ERole.ROLE_COMPRADOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(compradorRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  @PutMapping("/seller/{id}")
  public ResponseEntity<User> updateClient(@PathVariable("id") String id, @RequestBody User user) {
    Optional<User> userData = userRepository.findById(id);
    if (userData.isPresent()) {
      User _user = userData.get();
      _user.setBirthDate(user.getBirthDate());
      _user.setAddress(user.getAddress());
      _user.setCertificateCode(user.getCertificateCode());
      Set<Role> roles = new HashSet<>();
        {
          Role userRole = roleRepository.findByName(ERole.ROLE_COMPRADOR)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
        Role userRole = roleRepository.findByName(ERole.ROLE_VENDEDOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        _user.setRoles(roles);
      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
    Optional<User> userData = userRepository.findById(id);

    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

