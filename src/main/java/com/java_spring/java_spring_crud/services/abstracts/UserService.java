package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    void register(CreateUserRequest createUserRequest);
    String login(LoginRequest loginRequest);
}
