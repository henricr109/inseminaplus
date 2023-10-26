package com.inseminaplus.spring.security.mongodb.repository;
import java.util.List;


import com.inseminaplus.spring.security.mongodb.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameContaining(String name);
    List<Item> findByOrderId(Long postId);

}
