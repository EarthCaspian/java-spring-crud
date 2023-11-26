package com.java_spring.java_spring_crud.services.dtos.employee.requests;


import lombok.Data;

@Data
public class AddEmployeeRequest {
    private String name;
    private String surname;
    private String phone;
    private int customer_relation;
}
