package com.java_spring.java_spring_crud.services.dtos.customer.requests;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {

    @Positive
    @Size(min = 6, max = 6)
    private String nationalId;

    @NotBlank
    @Length(max = 10)
    private String name;

    @NotBlank
    @Length(max = 20)
    private String surname;

    @NotBlank
    @Length(max = 7)
    @Pattern(regexp = "^[0-9]*$")
    private String phone;

    @NotBlank
    @Length(max = 20)
    private String email;
}
