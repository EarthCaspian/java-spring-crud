package com.java_spring.java_spring_crud.services.dtos.rental.requests;


import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Location;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateRentalRequest {
    private int id;
    private Customer customer_id;
    private Car car_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private Location location_id;
}
