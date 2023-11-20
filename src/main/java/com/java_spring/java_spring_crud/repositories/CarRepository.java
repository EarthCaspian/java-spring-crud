package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
