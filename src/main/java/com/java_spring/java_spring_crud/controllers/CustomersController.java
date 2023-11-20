package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController
{
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    @GetMapping
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id) {return customerRepository.findById(id).orElseThrow();}

    @PostMapping
    public void add(@RequestBody Customer customer) {customerRepository.save(customer);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());
        customerRepository.save(customerToUpdate);
    }

}
