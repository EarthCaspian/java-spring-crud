package com.java_spring.java_spring_crud.services.dtos.employee.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Positive
    private int id;

    @NotBlank
    @Length
    private String name;

    @NotBlank
    @Length
    private String surname;

    @NotBlank
    @Pattern(regexp = "^[0-9]*$")
    private String phone;

    @Positive
    private int customer_relation;
}
