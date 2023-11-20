package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
