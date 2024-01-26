package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@CrossOrigin
public class CarsController
{
    private final CarService carService;

    public CarsController(CarService carService) { this.carService = carService;}


    @PreAuthorize("hasRole('mod')")
    @GetMapping
    public List<String> getAll() {
       return carService.getAll();
    }

    @GetMapping("{id}")
    public Car getById (GetCarRequest request) {
        return carService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request) {
        carService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteCarRequest request) {
        carService.deleteById(request);
    }

    @PutMapping("{id}")
    public void updateById(@Valid @RequestBody UpdateCarRequest request) {
        carService.update(request);
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
