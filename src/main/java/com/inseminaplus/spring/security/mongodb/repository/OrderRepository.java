package com.inseminaplus.spring.security.mongodb.repository;

import com.inseminaplus.spring.security.mongodb.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findById(String id);
    Collection<? extends Order> findByIdContaining(String id);
}
