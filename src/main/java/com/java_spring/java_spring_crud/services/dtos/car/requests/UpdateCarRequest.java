package com.java_spring.java_spring_crud.services.dtos.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @Positive
    private int id;

    @NotBlank
    private String status;

    @NotBlank
    private String color;

    @NotBlank
    @Length(min = 6)
    private String plate;

    @Positive
    @Min(value = 100)
    private double dailyPrice;
}
