package com.java_spring.java_spring_crud.services.dtos.rental.requests;


import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Location;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateRentalRequest {

    @Positive
    private int id;

    @Positive
    private int customer_id;

    @Positive
    private int car_id;

    @FutureOrPresent(message = "Kiralama başlangıç tarihi bugün veya gelecek bir tarih olmalıdır.")
    private LocalDate start_date;

    @Future(message = "Kiralama bitiş tarihi gelecekte bir tarih olmalıdır.")
    private LocalDate end_date;

    @Positive
    private int location_id;
}
