package com.inseminaplus.spring.security.mongodb.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  @Id
  private String userId;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(max = 120)
  private String password;
  @Size(max=30)
  private String birthDate;
  @Size(max=30)
  private String address;

  @Size(max=30)
  private String certificateCode;
  @DBRef(lazy = true)
  private List<Product> products;
  @DBRef(lazy = true)
  private List<Order> orders;
  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String birthDate, String address, String certificateCode) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.birthDate = birthDate;
    this.address = address;
    this.certificateCode = certificateCode;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCertificateCode() {
    return certificateCode;
  }

  public void setCertificateCode(String certificateCode) {
    this.certificateCode = certificateCode;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId='" + userId + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", birthDate='" + birthDate + '\'' +
            ", address='" + address + '\'' +
            ", certificateCode='" + certificateCode + '\'' +
            ", roles=" + roles +
            '}';
  }
}
