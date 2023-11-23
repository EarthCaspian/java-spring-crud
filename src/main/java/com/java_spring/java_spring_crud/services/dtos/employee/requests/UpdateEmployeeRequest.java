package com.java_spring.java_spring_crud.services.dtos.employee.requests;


import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private int id;
    private String phone;
}
