package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {
    public void add(AddEmployeeRequest request);
    public void deleteById(DeleteEmployeeRequest request);
    public void update(UpdateEmployeeRequest request);
    public Employee getById(GetEmployeeRequest request);
    public List<String> getAll();

}
