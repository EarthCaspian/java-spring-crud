package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@CrossOrigin
@Data
public class CarsController
{
    private final CarService carService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddCarRequest request) {
        return carService.add(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("{id}")
    public Result update(@Valid @RequestBody UpdateCarRequest request) {
        return carService.update(request);
    }

    @GetMapping("/getAll")
    public List<String> getAll() {
       return carService.getAll();
    }

    @GetMapping("{id}")
    public Car getById (GetCarRequest request) {
        return carService.getById(request);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("{id}")
    public void deleteById(DeleteCarRequest request) {
        carService.deleteById(request);
    }

    @GetMapping("contains")
    public List<GetModelNameResponse> findByModelNameContaining(@RequestParam String modelName) {
        return carService.findByModelNameContaining(modelName);
    }

    @GetMapping("status")
    public List<GetStatusResponse> getStatusResponses(@RequestParam String status) {
        return carService.getStatus(status);
    }
}
