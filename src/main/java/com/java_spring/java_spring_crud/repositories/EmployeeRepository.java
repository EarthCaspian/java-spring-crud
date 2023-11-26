package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse" +
            "(e.phone,e.name,e.surname,e.id) from Employee e where e.phone like ?1%")
    List<GetEmployeePhoneResponse> getByPhone(String phone);

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse" +
            "(c.id,e.name,e.surname) from Employee e join e.customer_relation c where c.id= :id")
    List<GetEmployeeByRelationResponse> getByRelation(int id);
}
