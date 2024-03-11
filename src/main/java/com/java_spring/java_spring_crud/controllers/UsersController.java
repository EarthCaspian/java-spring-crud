package com.java_spring.java_spring_crud.controllers;



import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.dtos.user.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;


    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@RequestParam int id) {
        return userService.getById(id);
    }

    @GetMapping("/findByUsername")
    public UserDetails findByName(@RequestParam String name) {
        return userService.loadUserByUsername(name);
    }
}
