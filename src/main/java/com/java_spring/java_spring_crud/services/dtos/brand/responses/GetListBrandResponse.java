package com.java_spring.java_spring_crud.services.dtos.brand.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListBrandResponse {
    private int id;
    private String name;
}
