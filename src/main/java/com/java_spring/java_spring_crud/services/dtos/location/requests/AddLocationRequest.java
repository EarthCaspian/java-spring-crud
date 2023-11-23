package com.java_spring.java_spring_crud.services.dtos.location.requests;


import com.java_spring.java_spring_crud.entities.Employee;
import lombok.Data;

@Data
public class AddLocationRequest {
    private String address;
    private String name;
    private int manager_id;
}
