package com.java_spring.java_spring_crud.services.dtos.location.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddLocationRequest {

    @NotBlank
    private String address;

    @NotBlank
    private String name;

    @Positive
    private int managerId;
}
