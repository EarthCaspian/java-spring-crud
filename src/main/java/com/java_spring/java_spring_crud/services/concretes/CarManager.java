package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final BrandService brandService;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;

    @Override
    public Result add(AddCarRequest request) {

        if (carRepository.existsCarByPlate(request.getPlate())){
            throw new RuntimeException("Aynı plaka ile 2. araç eklenemez.");
        }


        Car car = this.modelMapperService.forRequest().map(request,Car.class);
        car.setStatus("Available");


        Brand brand = brandService.getById(request.getBrandId());
        car.setBrand(brand);
        carRepository.save(car);

        return new SuccessResult(messageService.getMessage(Messages.Car.carAddSuccess));
    }

    @Override
    public Result update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Model bulunamadı."));
        carToUpdate.setDailyPrice(request.getDailyPrice());
        carToUpdate.setColor(request.getColor());
        carToUpdate.setStatus(request.getStatus());
        carToUpdate.setPlate(request.getPlate());
        carRepository.save(carToUpdate);

        return new SuccessResult(messageService.getMessage(Messages.Car.carUpdateSuccess));
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
        return carRepository.findAll().stream().filter(car -> car.getModelName().contains(modelName)).map(
                car -> new GetModelNameResponse(car.getModelName())).toList();
    }

    @Override
    public List<GetStatusResponse> getStatus(String status) {
        return carRepository.getStatus(status);
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Araç bulunamadı."));
    }
}
