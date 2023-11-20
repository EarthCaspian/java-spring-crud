package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController
{
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) { this.carRepository = carRepository;}

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
}
