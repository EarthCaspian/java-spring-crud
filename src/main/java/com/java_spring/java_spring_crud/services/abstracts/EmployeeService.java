package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse;

import java.util.List;

public interface EmployeeService {
    void add(AddEmployeeRequest request);
    void deleteById(DeleteEmployeeRequest request);
    void update(UpdateEmployeeRequest request);
    Employee getById(GetEmployeeRequest request);
    List<String> getAll();
    List<GetEmployeePhoneResponse> getByPhone(String phone);

    List<GetEmployeeByRelationResponse> getByRelation(int id);

    Employee getById(int id);

}
