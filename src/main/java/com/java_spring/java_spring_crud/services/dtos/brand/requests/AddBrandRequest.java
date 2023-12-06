package com.java_spring.java_spring_crud.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest
{
    @NotBlank
    private String name;
}
