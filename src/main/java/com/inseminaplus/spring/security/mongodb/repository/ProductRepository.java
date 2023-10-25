package com.inseminaplus.spring.security.mongodb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inseminaplus.spring.security.mongodb.models.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

}

