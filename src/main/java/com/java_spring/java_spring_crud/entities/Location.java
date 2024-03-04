package com.java_spring.java_spring_crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java_spring.java_spring_crud.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table (name = "locations")
@Entity
@Getter
@Setter
public class Location extends BaseEntity
{


    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee managerId;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Rental> rentals;
}
