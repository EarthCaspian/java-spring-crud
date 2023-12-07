package com.java_spring.java_spring_crud.services.dtos.customer.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCustomerRequest {
    @Positive
    private int id;

    @NotBlank
    @Length(max = 7, message = "Boş bırakılamaz, en fazla 7 karakter.")
    @Pattern(regexp = "^[0-9]*$", message = "Sadece rakam giriniz.")
    private String phone;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String email;
}
