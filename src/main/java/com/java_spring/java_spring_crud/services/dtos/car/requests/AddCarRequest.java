package com.java_spring.java_spring_crud.services.dtos.car.requests;

import lombok.Data;

@Data
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private double dailyPrice;
    private String color;
    private String Status;
}
