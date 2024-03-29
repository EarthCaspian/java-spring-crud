package com.java_spring.java_spring_crud.entities;

import com.java_spring.java_spring_crud.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table (name = "rentals")
@Entity
@Getter
@Setter
public class Rental extends BaseEntity
{

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
