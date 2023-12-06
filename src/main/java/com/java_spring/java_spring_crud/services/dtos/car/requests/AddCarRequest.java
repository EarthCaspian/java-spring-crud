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
public class AddCarRequest {

    @Min(value = 2000, message = "Model yılı en az 2000 olmalıdır.")
    private int modelYear;

    @NotBlank(message = "Model adı boş olamaz.")
    private String modelName;

    @Positive(message = "Pozitif bir değer giriniz.")
    private double dailyPrice;

    @NotBlank(message = "Renk boş olamaz.")
    private String color;

    @NotBlank(message = "Plaka boş olamaz.")
    @Length(min = 6, message = "Plaka en az 6 haneden oluşmalıdır.")
    private String plate;

    @Positive(message = "Pozitif bir değer giriniz.")
    private int brandId;
}
