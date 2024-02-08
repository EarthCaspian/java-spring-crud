package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.core.services.JwtService;
import com.java_spring.java_spring_crud.services.abstracts.AuthService;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import com.java_spring.java_spring_crud.services.dtos.user.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;


    @GetMapping("getAll")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }
}
