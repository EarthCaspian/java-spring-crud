package com.java_spring.java_spring_crud.services.dtos.location.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationByAddressLength {
    private String address;
    private String name;
}
