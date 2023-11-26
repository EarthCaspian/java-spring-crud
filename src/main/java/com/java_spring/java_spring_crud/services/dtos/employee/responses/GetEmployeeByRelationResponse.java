package com.java_spring.java_spring_crud.services.dtos.employee.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeByRelationResponse {
    private int customer_relation;
    private String name;
    private String surname;
}
