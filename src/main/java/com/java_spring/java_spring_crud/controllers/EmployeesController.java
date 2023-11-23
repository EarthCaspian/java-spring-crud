package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController
{
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<String> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(GetEmployeeRequest request) {
        return employeeService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest request) {
        employeeService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteEmployeeRequest request) {
        employeeService.deleteById(request);
    }

    @PutMapping("{id}")
    public void update(UpdateEmployeeRequest request) {
        employeeService.update(request);
    }

    /*
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
     */
}
