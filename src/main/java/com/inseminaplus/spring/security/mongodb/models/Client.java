package com.inseminaplus.spring.security.mongodb.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="birthDate")
    private Date birthDate;
    @Column(name="address")
    private String address;
    @Column(name="certificateCode")
    private Integer certificateCode;
    @Column(name="email")
    private String email;

    public Client(){

    }

    public Client( String name, Date birthDate, String address, Integer certificateCode, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.certificateCode = certificateCode;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(Integer certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", certificateCode=" + certificateCode +
                ", email='" + email + '\'' +
                '}';
    }
}
