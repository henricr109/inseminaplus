package com.inseminaplus.spring.security.mongodb.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inseminaplus.spring.security.mongodb.models.Product;
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAll(); // find all products
    List<Product> findByCategory(boolean category);
    List<Product> findByTitleContaining(String name);
}

