package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    List<String> getAll();
    Brand getById(GetBrandRequest request);
    void deleteById(DeleteBrandRequest request);

    List<GetListBrandResponse> getByNameDto(String name);

    List<Brand> getByName(String name);
}
