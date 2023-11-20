package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
