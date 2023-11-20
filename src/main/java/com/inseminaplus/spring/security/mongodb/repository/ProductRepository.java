package com.inseminaplus.spring.security.mongodb.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inseminaplus.spring.security.mongodb.models.Product;
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContaining(String name);
    Optional<Product> findById(String id);

    List<Product> findByFkUserId(String fkUserId);

    List<Product> findByRace(String race);
}

