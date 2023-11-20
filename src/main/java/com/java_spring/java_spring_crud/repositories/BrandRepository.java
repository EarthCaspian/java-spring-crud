package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
