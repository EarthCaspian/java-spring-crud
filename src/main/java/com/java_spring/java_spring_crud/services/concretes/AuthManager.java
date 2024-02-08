package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.services.JwtService;
import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.services.abstracts.AuthService;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public void register(CreateUserRequest createUserRequest) {
        Set<RoleEntity> authorities = createUserRequest.getRoles().stream()
                .map(roleService::findByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        User user = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .authorities(authorities)
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();
        userService.save(user);
    }

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
