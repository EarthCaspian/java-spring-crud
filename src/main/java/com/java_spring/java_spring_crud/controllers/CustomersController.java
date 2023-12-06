package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse;
import jakarta.validation.Valid;
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
    public void add(@RequestBody @Valid AddCustomerRequest request) {
        customerService.add(request);
    }

    @DeleteMapping
    public void deleteById(DeleteCustomerRequest request){
        customerService.deleteById(request);
    }

    @PutMapping("{id}")
    public void updateById(@Valid @RequestBody UpdateCustomerRequest request) {
        customerService.update(request);
    }

    @GetMapping("nameSurname")
    public List<GetCustomerNameResponse> getCustomerNameResponses (@RequestParam String name) {
        return customerService.getBySurnameOrName(name);
    }

    @GetMapping("getByNIDEndsWith")
    public List<GetCustomerNIDResponse>  getCustomerNIDResponses(@RequestParam int id){
        return customerService.getByNIDEndsWith(id);
    }
}
