package com.inseminaplus.spring.security.mongodb.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(max = 15)
  private String cpf;

  @NotBlank
  @Size(max = 15)
  private String afe;;


  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  @Size(max=100)
  private String address;


  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String cpf, String afe, String address) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
    this.afe = afe;
    this.address = address;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getAfe() {
    return afe;
  }

  public void setAfe(String afe) {
    this.afe = afe;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", cpf='" + cpf + '\'' +
            ", afe='" + afe + '\'' +
            ", password='" + password + '\'' +
            ", address='" + address + '\'' +
            ", roles=" + roles +
            '}';
  }
}
