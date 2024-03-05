package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;

public interface AuthService {

    String register(CreateUserRequest createUserRequest);
    String login (LoginRequest loginRequest);
}
