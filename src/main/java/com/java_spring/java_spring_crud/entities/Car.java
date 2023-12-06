package com.java_spring.java_spring_crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "cars")
@Entity
@Getter
@Setter
public class Car
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
    private String status;

    @Column(name = "plate")
    private String plate;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
}
