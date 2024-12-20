package com.example.userservice.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    Optional<User> findByKeycloakId(String keycloakId);
}
