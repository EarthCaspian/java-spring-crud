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

    @NotBlank(message = "Boş bırakılamaz.")
    private String status;

    @NotBlank(message = "Boş bırakılamaz.")
    private String color;

    @NotBlank(message = "Boş bırakılamaz.")
    @Length(min = 6, message = "Plaka en az 6 haneden oluşmalıdır.")
    private String plate;

    @NotBlank(message = "Model adı boş olamaz.")
    private String modelName;

    @Positive
    @Min(value = 100)
    private double dailyPrice;
}
