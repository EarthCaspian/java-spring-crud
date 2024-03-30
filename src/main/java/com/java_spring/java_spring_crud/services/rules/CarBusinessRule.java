package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CarBusinessRule {
    private final CarRepository carRepository;
    private final MessageService messageService;

    public void existsCarByPlate(String plate) {
        if (carRepository.existsCarByPlate(plate)){
            throw new BusinessException(messageService.getMessage(Messages.Car.getSameCarPlateMessage));
        }
    }

    public void existsCarById(int id) {
        if (!carRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Car.getCarNotFoundMessage));
        }
    }

}
