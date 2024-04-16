package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@CrossOrigin
@Data
public class BrandsController
{

    private final BrandService brandService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddBrandRequest request){
        return brandService.add(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("{id}")
    public Result update(@RequestBody @Valid UpdateBrandRequest request) {
        return brandService.update(request);
    }

    @GetMapping("/getAll")
    public List<String> getAll(){
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public Brand getById(GetBrandRequest request) {
        return brandService.getById(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteBrandRequest request){
        brandService.deleteById(request);
    }

    @GetMapping("/getByNameDto")
    public List<GetListBrandResponse> getByNameDto(@RequestParam String name) {
        return brandService.getByNameDto(name);
    }

    @GetMapping("/getByName")
    public List<Brand> getByName(@RequestParam String name) {
        return brandService.getByName(name);
    }


}
