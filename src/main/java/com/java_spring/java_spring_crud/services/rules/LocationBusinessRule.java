package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.repositories.LocationRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationBusinessRule {

    private final LocationRepository locationRepository;
    private final MessageService messageService;

    public void checkAddress(String address) {
        if (locationRepository.existsByAddressIgnoreCase(address)){
            System.out.println("duplicate address found.");
            throw new BusinessException(messageService.getMessage(Messages.Location.locationAddressExists));
        }
    }

}
