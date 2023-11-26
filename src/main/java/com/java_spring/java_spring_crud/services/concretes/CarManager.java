package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request) {

        if (request.getModelName() == null)
            throw new RuntimeException("İsim boş bırakılamaz.");

        Car car = new Car();
        car.setModelYear(request.getModelYear());
        car.setModelName(request.getModelName());
        car.setDailyPrice(request.getDailyPrice());
        car.setColor(request.getColor());
        car.setStatus(request.getStatus());
        carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Model bulunamadı."));
        carToUpdate.setDailyPrice(request.getDailyPrice());
        carToUpdate.setColor(request.getColor());
        carToUpdate.setStatus(request.getStatus());
        carRepository.save(carToUpdate);
    }

    @Override
    public List<String> getAll() {
        return carRepository.findAll().stream()
                                      .map(Car::getModelName)
                                      .collect(Collectors.toList());
    }

    @Override
    public Car getById(GetCarRequest request) {
        return carRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Model bulunamadı."));
    }

    @Override
    public void deleteById(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Model bulunamadı."));
        carRepository.delete(carToDelete);
    }

    @Override
    public List<GetModelNameResponse> findByModelNameContaining(String modelName) {
        return carRepository.findByModelNameContaining(modelName);
    }

    @Override
    public List<GetStatusResponse> getStatus(String status) {
        return carRepository.getStatus(status);
    }
}
