package com.java_spring.java_spring_crud.services.dtos.user;

import com.java_spring.java_spring_crud.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String username;
    private String password;
    private List<String> roles;
}
