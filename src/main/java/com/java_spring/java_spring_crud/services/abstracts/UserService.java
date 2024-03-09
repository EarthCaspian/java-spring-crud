package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import com.java_spring.java_spring_crud.services.dtos.user.responses.GetAllUsersResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    void save(User user);
    List<GetAllUsersResponse> getAll();

    User getById(int id);
}
