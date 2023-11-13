package com.inseminaplus.spring.security.mongodb.models;

import java.util.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.bson.types.Binary;
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
  @Size(max = 120)
  private String password;
  @Size(max=30)
  private String birthDate;
  @Size(max=10)
  private String cep;
  @Size(max=30)
  private String address;
  @Size(max=30)
  private String certificateCode;
  private String image;
  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String birthDate, String cep, String address, String certificateCode, String image) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.birthDate = birthDate;
    this.cep = cep;
    this.address = address;
    this.certificateCode = certificateCode;
    this.image = image;
  }

  public String getId() {
    return id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId='" + id + '\'' +
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
