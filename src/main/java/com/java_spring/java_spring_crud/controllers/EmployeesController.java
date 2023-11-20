package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController
{
    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){return employeeRepository.findById(id).orElseThrow();}

    @PostMapping
    public void add(@RequestBody Employee employee) {employeeRepository.save(employee);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setPhone(employee.getPhone());
        employeeRepository.save(employeeToUpdate);
    }
}
