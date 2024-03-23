package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.services.JwtService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.services.abstracts.AuthService;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.constants.Messages;
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
    private final MessageService messageService;

    @Override
    public Result register(CreateUserRequest createUserRequest) {
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
        return new SuccessResult(messageService.getMessage(Messages.User.userAddSuccess));
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
