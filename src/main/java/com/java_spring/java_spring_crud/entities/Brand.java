package com.java_spring.java_spring_crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java_spring.java_spring_crud.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "brands")
@Entity
@Getter
@Setter
public class Brand extends BaseEntity
{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Car> cars;
}