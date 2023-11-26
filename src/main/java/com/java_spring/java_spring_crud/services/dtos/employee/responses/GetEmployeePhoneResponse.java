package com.java_spring.java_spring_crud.services.dtos.employee.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeePhoneResponse {
    private String phone;
    private String name;
    private String surname;
    private int id;
}
