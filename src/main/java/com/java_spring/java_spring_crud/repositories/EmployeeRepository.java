package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
