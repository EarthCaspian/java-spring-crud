package com.java_spring.java_spring_crud.services.dtos.customer.requests;


import lombok.Data;

@Data
public class AddCustomerRequest {
    private int national_id;
    private String name;
    private String surname;
    private String phone;
    private String email;
}
