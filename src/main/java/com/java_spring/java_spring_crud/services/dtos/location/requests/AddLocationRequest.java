package com.java_spring.java_spring_crud.services.dtos.location.requests;


import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
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

    @NotBlank
    @Length(max = 50)
    private String address;

    @NotBlank
    @Length(max = 30)
    private String name;

    @Positive
    private int managerId;
}
