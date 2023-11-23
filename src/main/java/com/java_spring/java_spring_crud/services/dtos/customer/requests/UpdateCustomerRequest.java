package com.java_spring.java_spring_crud.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String phone;
    private String email;
}
