package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController
{

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }



    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest request){
        brandService.add(request);
    }

    @GetMapping
    public List<String> getAll(){
        return brandService.getAll();
    }

    @PutMapping("{id}")
    public void update(@RequestBody @Valid UpdateBrandRequest request) {
        brandService.update(request);
    }

    @GetMapping("{id}")
    public Brand getById(GetBrandRequest request) {
        return brandService.getById(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteBrandRequest request){
        brandService.deleteById(request);
    }

    @GetMapping("dto")
    public List<GetListBrandResponse> getByNameDto(@RequestParam String name) {
        return brandService.getByNameDto(name);
    }

    @GetMapping("name")
    public List<Brand> getByName(@RequestParam String name) {
        return brandService.getByName(name);
    }


}
