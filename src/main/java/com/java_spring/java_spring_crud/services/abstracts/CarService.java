package com.java_spring.java_spring_crud.services.abstracts;



import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.dtos.car.requests.AddCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.DeleteCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.GetCarRequest;
import com.java_spring.java_spring_crud.services.dtos.car.requests.UpdateCarRequest;

import java.util.List;

public interface CarService {
    public void add(AddCarRequest request);
    public void update(UpdateCarRequest request);
    public List<String> getAll();
    public Car getById(GetCarRequest request);
    public void deleteById(DeleteCarRequest request);
}
