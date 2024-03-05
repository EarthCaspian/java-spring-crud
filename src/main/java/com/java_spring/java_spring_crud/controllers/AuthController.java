package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.services.abstracts.AuthService;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;


    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody CreateUserRequest request) {
        return authService.register(request);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);

    }
}
