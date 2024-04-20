package com.java_spring.java_spring_crud.services.rules;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.repositories.RentalRepository;
import com.java_spring.java_spring_crud.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRule {
    private final RentalRepository rentalRepository;
    private final MessageService messageService;

    public void existsRentalById(int id) {
        if (!rentalRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.rentalNotFoundMessage));
        }
    }

    public void checkStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.rentalStartDateError));
        }
    }

    public void checkEndDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.rentalEndDateError));
        }
    }

    public void checkRentalPeriod(LocalDate startDate, LocalDate endDate) {
        if (ChronoUnit.DAYS.between(startDate, endDate) > 25) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.rentalPeriodExceeded));
        }
    }

}
