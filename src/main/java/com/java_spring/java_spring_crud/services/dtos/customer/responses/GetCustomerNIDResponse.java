package com.java_spring.java_spring_crud.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerNIDResponse {
    private int nationalId;
    private String name;
    private String surname;
}
