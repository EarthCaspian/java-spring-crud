package com.java_spring.java_spring_crud.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @Positive
    private int id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String name;
}
