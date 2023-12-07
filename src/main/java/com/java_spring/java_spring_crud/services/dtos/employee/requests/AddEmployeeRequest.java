package com.java_spring.java_spring_crud.services.dtos.employee.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddEmployeeRequest {

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String name;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String surname;

    @NotBlank(message = "Boş bırakılamaz.")
    @Pattern(regexp = "^[0-9]*$", message = "Sadece rakam giriniz.")
    private String phone;

    @Positive
    private int customer_relation;
}
