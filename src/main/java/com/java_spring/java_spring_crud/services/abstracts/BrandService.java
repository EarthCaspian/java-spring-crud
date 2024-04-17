package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    Result add(AddBrandRequest request);
    Result update(UpdateBrandRequest request);
    List<String> getAll();
    Brand getById(GetBrandRequest request);
    Result deleteById(DeleteBrandRequest request);

    List<GetListBrandResponse> getByNameDto(String name);

    List<Brand> getByName(String name);

    Brand getById(int id);
}
