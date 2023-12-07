package com.java_spring.java_spring_crud.services.dtos.employee.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Positive
    private int id;

    @NotBlank
    @Pattern(regexp = "^[0-9]*$", message = "Sadece rakam giriniz.")
    private String phone;

    @Positive
    private int customer_relation;
}
