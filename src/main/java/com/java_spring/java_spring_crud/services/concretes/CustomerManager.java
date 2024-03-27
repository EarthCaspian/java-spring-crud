package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.AddCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.DeleteCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.GetCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.requests.UpdateCustomerRequest;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNIDResponse;
import com.java_spring.java_spring_crud.services.dtos.customer.responses.GetCustomerNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;

    @Override
    public Result add(AddCustomerRequest request) {

        if (customerRepository.existsByNationalId(request.getNationalId())){
            throw new RuntimeException("Bu kimlik numarası sistemde kayıtlı.");
        }

        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        customerRepository.save(customer);
        return new SuccessResult(messageService.getMessage(Messages.Customer.customerAddSuccess));
    }

    @Override
    public Result update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
        customerToUpdate.setPhone(request.getPhone());
        customerToUpdate.setEmail(request.getEmail());
        customerRepository.save(customerToUpdate);
        return new SuccessResult(messageService.getMessage(Messages.Customer.customerUpdateSuccess));
    }

    @Override
    public Result deleteById(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
        customerRepository.delete(customerToDelete);
        return new SuccessResult(messageService.getMessage(Messages.Customer.customerDeleteSuccess));
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
        return customerRepository.findBySurnameOrName(name).stream().map((customer) -> new GetCustomerNameResponse(
                customer.getSurname(), customer.getName(),customer.getEmail()
        )).toList();
    }

    @Override
    public List<GetCustomerNIDResponse> getByNIDEndsWith(int id) {
        return customerRepository.getByNIDEndsWith(id);
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));
    }
}
