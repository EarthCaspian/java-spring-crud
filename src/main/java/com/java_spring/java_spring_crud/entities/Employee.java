package com.java_spring.java_spring_crud.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table (name = "employees")
@Entity
@Getter
@Setter
public class Employee
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name="customer_relation")
    private Customer customer_relation;

    @OneToMany(mappedBy = "managerId")
    @JsonIgnore
    private List<Location> locations;
}
