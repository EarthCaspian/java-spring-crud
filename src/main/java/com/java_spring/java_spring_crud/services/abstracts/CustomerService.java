package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void deleteById(DeleteCustomerRequest request);
    Customer getById(GetCustomerRequest request);
    List<String> getAll();
    List<GetCustomerNameResponse> getBySurnameOrName(String name);
    List<GetCustomerNIDResponse> getByNIDEndsWith(int id);
}
