package com.java_spring.java_spring_crud.services.dtos.rental.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalByDateResponse {
    private LocalDate start_date;
    private LocalDate end_date;
    private int id;
}
