package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.NotFoundException;
import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.entities.User;
import com.java_spring.java_spring_crud.repositories.UserRepository;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.abstracts.UserService;
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.user.CreateUserRequest;
import com.java_spring.java_spring_crud.services.dtos.user.LoginRequest;
import com.java_spring.java_spring_crud.services.dtos.user.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
                .toList();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(messageService.getMessage(Messages.User.getUserNotFoundMessage)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
