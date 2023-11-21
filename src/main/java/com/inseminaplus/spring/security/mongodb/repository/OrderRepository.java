package com.inseminaplus.spring.security.mongodb.repository;

import com.inseminaplus.spring.security.mongodb.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends MongoRepository<Order, String> {
    Optional<Order> findById(String id);
    List<Order> findByFkUserId(String fkUserId);
    Collection<? extends Order> findByIdContaining(String id);

    List<Order> findByBuyerId(String buyerId);

    Optional<Order> findByproductId(String productId);
}
