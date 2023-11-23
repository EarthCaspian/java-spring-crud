package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    public void add(AddCustomerRequest request);
    public void update(UpdateCustomerRequest request);
    public void deleteById(DeleteCustomerRequest request);
    public Customer getById(GetCustomerRequest request);
    public List<String> getAll();
}
