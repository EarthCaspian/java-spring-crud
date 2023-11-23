package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;

import java.util.List;

public interface BrandService {
    public void add(AddBrandRequest request);
    public void update(UpdateBrandRequest request);
    public List<String> getAll();
    public Brand getById(GetBrandRequest request);
    public void deleteById(DeleteBrandRequest request);
}
