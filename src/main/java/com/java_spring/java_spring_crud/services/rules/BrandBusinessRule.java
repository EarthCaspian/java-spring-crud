package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.repositories.BrandRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRule {

    private final BrandRepository brandRepository;
    private final MessageService messageService;

    public void checkBrandNameLength(String name) {
        if (name.length() < 3)
            throw new BusinessException(messageService.getMessage(Messages.Brand.brandNameLengthCheck));
    }

    public void checkUpperCase(String name) {
        if(!Character.isUpperCase(name.charAt(0))){
            throw new BusinessException(messageService.getMessage(Messages.Brand.brandNameCapitalLetterCheck));
        }
    }

    public void brandNameAlreadyExists(String name) {
        if(brandRepository.existsByName(name)){
            throw new BusinessException(messageService.getMessage(Messages.Brand.getBrandNameAlreadyExistsMessage));
        }
    }
}
