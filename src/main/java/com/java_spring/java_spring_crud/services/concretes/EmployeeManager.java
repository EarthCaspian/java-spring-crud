package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    public EmployeeManager(EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddEmployeeRequest request) {
        if (request.getName().length() > 15)
            throw new RuntimeException("Karakter sınırını aştınız.");

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setPhone(request.getPhone());
        Customer customer = customerRepository.findById(request.getCustomer_relation())
                .orElseThrow(() -> new RuntimeException("Bulunamadı"));
        employee.setCustomer_relation(customer);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(DeleteEmployeeRequest request) {
        Employee employeeToDelete = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı."));
        employeeRepository.delete(employeeToDelete);
    }

    @Override
    public void update(UpdateEmployeeRequest request) {
        Employee employeeToUpdate = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı."));
        employeeToUpdate.setPhone(request.getPhone());
        Customer customer = customerRepository.findById(request.getId()).get();
        employeeToUpdate.setCustomer_relation(customer);
        employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee getById(GetEmployeeRequest request) {
        return employeeRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı."));
    }

    @Override
    public List<String> getAll() {
        return employeeRepository.findAll().stream()
                .map(Employee::getName)
                .toList();
    }

    @Override
    public List<GetEmployeePhoneResponse> getByPhone(String phone) {
        return employeeRepository.getByPhone(phone);
    }

    @Override
    public List<GetEmployeeByRelationResponse> getByRelation(int id) {
        return employeeRepository.getByRelation(id);
    }
}
