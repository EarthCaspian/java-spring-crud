package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController
{
   private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<String> getAll() {
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Customer getById(GetCustomerRequest request) {
        return customerService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }

    @DeleteMapping
    public void deleteById(DeleteCustomerRequest request){
        customerService.deleteById(request);
    }

    @PutMapping("{id}")
    public void updateById(UpdateCustomerRequest request) {
        customerService.update(request);
    }

   /*
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
    */
}
