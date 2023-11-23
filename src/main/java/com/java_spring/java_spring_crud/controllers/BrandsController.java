package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
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
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @GetMapping
    public List<String> getAll(){
        return brandService.getAll();
    }

    @PutMapping("{id}")
    public void update(UpdateBrandRequest request) {
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

    /*
    @GetMapping
    public List<Brand> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
       return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand brand){
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        brandToUpdate.setName(brand.getName());
        brandRepository.save(brandToUpdate);

    }
    */
}
