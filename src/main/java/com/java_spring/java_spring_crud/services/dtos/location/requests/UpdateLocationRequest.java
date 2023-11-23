package com.java_spring.java_spring_crud.services.dtos.location.requests;

import com.java_spring.java_spring_crud.entities.Employee;
import lombok.Data;

@Data
public class UpdateLocationRequest {
    private int id;
    private String address;
    private String name;
    private Employee manager_id;
}
