package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeBusinessRule {

    private final EmployeeRepository employeeRepository;
    private final MessageService messageService;


    public void checkEmployeeNameLength(String name) {
        if (name.length() > 15) {
            throw new BusinessException (messageService.getMessage(Messages.Employee.employeeNameCheck));
        }
    }

    public void existsById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Employee.employeeNotFoundMessage));
        }
    }

}
