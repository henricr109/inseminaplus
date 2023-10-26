package com.inseminaplus.spring.security.mongodb.repository;

import com.inseminaplus.spring.security.mongodb.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNameContaining(String name);
}