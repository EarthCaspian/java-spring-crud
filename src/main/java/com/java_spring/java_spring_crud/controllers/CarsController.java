package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController
{
    private final CarService carService;

    public CarsController(CarService carService) { this.carService = carService;}


    @GetMapping
    public List<String> getAll() {
       return carService.getAll();
    }

    @GetMapping("{id}")
    public Car getById (GetCarRequest request) {
        return carService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        carService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteCarRequest request) {
        carService.deleteById(request);
    }

    @PutMapping("{id}")
    public void updateById(UpdateCarRequest request) {
        carService.update(request);
    }

    /*
    @GetMapping
    public List<Car> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setColor(car.getColor());
        carToUpdate.setStatus(car.getStatus());
        carToUpdate.setDailyPrice(car.getDailyPrice());
        carRepository.save(carToUpdate);
    }
     */
}
