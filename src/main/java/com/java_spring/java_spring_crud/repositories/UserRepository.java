package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
