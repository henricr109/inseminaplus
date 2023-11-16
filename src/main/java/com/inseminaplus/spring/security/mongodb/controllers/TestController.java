package com.inseminaplus.spring.security.mongodb.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public Boolean allAccess() {
    return true;
  }

  @GetMapping("/comprador")
  @PreAuthorize("hasRole('COMPRADOR') or hasRole('VENDEDOR') or hasRole('ADMIN')")
  public Boolean compradorAccess() {
    return true;
  }

  @GetMapping("/vendedor")
 @PreAuthorize("hasRole('VENDEDOR')")
  public Boolean vendedorAccess() {
    return true;
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public Boolean adminAccess() {
    return true;
  }
}
