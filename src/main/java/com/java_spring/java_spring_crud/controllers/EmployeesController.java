package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@CrossOrigin
@Data
public class EmployeesController
{
    private final EmployeeService employeeService;


    @GetMapping("/getAll")
    public List<String> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(GetEmployeeRequest request) {
        return employeeService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddEmployeeRequest request) {
        employeeService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteEmployeeRequest request) {
        employeeService.deleteById(request);
    }

    @PutMapping("{id}")
    public void update(@Valid @RequestBody UpdateEmployeeRequest request) {
        employeeService.update(request);
    }

    @GetMapping("phoneStarts-with")
    public List<GetEmployeePhoneResponse> getEmployeePhoneResponses(@RequestParam String phone) {
       return employeeService.getByPhone(phone);
    }

    @GetMapping("byCustomerRelation")
    public List<GetEmployeeByRelationResponse> getEmployeeByRelationResponses(@RequestParam int id) {
        return employeeService.getByRelation(id);
    }
}
