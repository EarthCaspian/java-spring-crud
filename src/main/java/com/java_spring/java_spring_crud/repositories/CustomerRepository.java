package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse" +
            "(c.surname,c.name,c.email) from Customer c where c.surname= :name or c.name= :name")
    List<GetCustomerNameResponse> findBySurnameOrName(String name);

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse" +
            "(c.national_id,c.name,c.surname) from Customer c where cast(c.national_id as string) like %?1")
    List<GetCustomerNIDResponse> getByNIDEndsWith(int id);
}
