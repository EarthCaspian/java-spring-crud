package com.java_spring.java_spring_crud.services.dtos.location.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLocationByManagerResponse {
    private int manager_id;
    private String address;
    private String name;
}
