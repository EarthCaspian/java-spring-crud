package com.java_spring.java_spring_crud.services.dtos.customer.requests;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {

    @Positive
    @Min(value= 6, message = "6 haneli olmalıdır.")
    @Max(value = 6,message = "6 haneli olmalıdır.")
    private int nationalId;

    @NotBlank
    @Length(max = 10, message = "Boş bırakılamaz, en fazla 10 karakter.")
    private String name;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String surname;

    @NotBlank
    @Length(max = 7, message = "Boş bırakılamaz, en fazla 7 karakter.")
    private String phone;

    @NotBlank
    @Length(max = 20, message = "Boş bırakılamaz, en fazla 20 karakter.")
    private String email;
}
