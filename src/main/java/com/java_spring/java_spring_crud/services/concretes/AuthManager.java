package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.services.JwtService;
import com.java_spring.java_spring_crud.services.abstracts.AuthService;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(loginRequest.getUsername());
        }

        throw new RuntimeException("Password or username is incorrect.");
    }
}
