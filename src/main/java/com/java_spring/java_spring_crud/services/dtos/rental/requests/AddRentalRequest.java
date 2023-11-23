package com.java_spring.java_spring_crud.services.dtos.rental.requests;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRentalRequest {
    private Integer customer_id;
    private int car_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private int location_id;
}
