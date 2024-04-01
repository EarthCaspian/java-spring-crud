package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRule {
    private final CustomerRepository customerRepository;
    private final MessageService messageService;

    public void existsCustomerById(int id) {
        if (!customerRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Customer.getCustomerNotFoundMessage));
        }
    }
}
