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
    @Size(min = 6, max = 6, message = "6 haneli olmalıdır.")
    private String nationalId;

    @NotBlank
    @Length(max = 10, message = "Boş bırakılamaz, en fazla 10 karakter.")
    private String name;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String surname;

    @NotBlank
    @Length(max = 7, message = "Boş bırakılamaz, en fazla 7 karakter.")
    @Pattern(regexp = "^[0-9]*$", message = "Sadece rakam giriniz.")
    private String phone;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String email;
}
