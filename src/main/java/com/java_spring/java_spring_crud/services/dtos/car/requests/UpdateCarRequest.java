package com.java_spring.java_spring_crud.services.dtos.car.requests;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private int id;
    private String name;
    private String status;
    private String color;
    private double dailyPrice;
}
