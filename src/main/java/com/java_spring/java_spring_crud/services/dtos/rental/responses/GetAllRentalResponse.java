package com.java_spring.java_spring_crud.services.dtos.rental.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAllRentalResponse {
    private int id;
    private LocalDate start_date;
    private LocalDate end_date;
}
