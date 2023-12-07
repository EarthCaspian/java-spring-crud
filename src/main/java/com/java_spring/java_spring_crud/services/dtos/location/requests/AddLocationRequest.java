package com.java_spring.java_spring_crud.services.dtos.location.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddLocationRequest {

    @NotBlank(message = "Boş bırakılamaz.")
    @Length(max = 50, message = "Boş bırakılamaz, en fazla 50 karakter.")
    private String address;

    @NotBlank(message = "Boş bırakılamaz.")
    @Length(max = 30, message = "Boş bırakılamaz, en fazla 30 karakter.")
    private String name;

    @Positive
    private int managerId;
}
