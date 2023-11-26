package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setNational_id(request.getNational_id());
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
        customerToUpdate.setPhone(request.getPhone());
        customerToUpdate.setEmail(request.getEmail());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteById(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
        customerRepository.delete(customerToDelete);
    }

    @Override
    public Customer getById(GetCustomerRequest request) {
        return customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
    }

    @Override
    public List<String> getAll() {
        return customerRepository.findAll().stream()
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetCustomerNameResponse> getBySurnameOrName(String name) {
        return customerRepository.findBySurnameOrName(name);
    }

    @Override
    public List<GetCustomerNIDResponse> getByNIDEndsWith(int id) {
        return customerRepository.getByNIDEndsWith(id);
    }
}
