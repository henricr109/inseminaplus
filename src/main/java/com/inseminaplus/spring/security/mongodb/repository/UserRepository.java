package com.inseminaplus.spring.security.mongodb.repository;

import java.util.Optional;
import com.inseminaplus.spring.security.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Boolean existsByEmail(String email);
  Optional<User> findByEmail(String email);
  Optional<User> findById(String id);

    Optional<Object> findByUsername(String username);
}
