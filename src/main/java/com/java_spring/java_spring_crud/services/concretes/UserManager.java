package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.repositories.UserRepository;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;

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
            userRepository.save(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
