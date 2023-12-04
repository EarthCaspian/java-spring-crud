package com.java_spring.java_spring_crud.services.dtos.rental.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllRentalResponse {
    private int id;
    private LocalDate start_date;
    private LocalDate end_date;
    private int customer_id;
    private int car_id;
    private int location_id;
}
