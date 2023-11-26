package com.java_spring.java_spring_crud.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStatusResponse {
    private String status;
    private int id;
    private String modelName;
}
