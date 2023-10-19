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
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/comprador")
  @PreAuthorize("hasRole('COMPRADOR') or hasRole('VENDEDOR') or hasRole('ADMIN')")
  public String compradorAccess() {
    return "Comprador Content.";
  }

  @GetMapping("/vendedor")
 @PreAuthorize("hasRole('VENDEDOR')")
  public String vendedorAccess() {
    return "Vendedor Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
