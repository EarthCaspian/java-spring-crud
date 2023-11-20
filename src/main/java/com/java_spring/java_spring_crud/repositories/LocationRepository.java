package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
