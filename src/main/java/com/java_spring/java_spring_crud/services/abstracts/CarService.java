package com.java_spring.java_spring_crud.services.abstracts;



import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    List<String> getAll();
    Car getById(GetCarRequest request);
    void deleteById(DeleteCarRequest request);

    List<GetModelNameResponse> findByModelNameContaining(String modelName);
    List<GetStatusResponse> getStatus(String status);

    Car getById(int id);
}
