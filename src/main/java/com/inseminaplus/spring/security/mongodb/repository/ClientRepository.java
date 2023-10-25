package com.inseminaplus.spring.security.mongodb.repository;

import com.inseminaplus.spring.security.mongodb.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Collection<? extends Client> findByNameContaining(String name);
}
