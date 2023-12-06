package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse;
import com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.car.responses.GetModelNameResponse(c.modelName)" +
            "from Car c where c.modelName like  %?1% ")
    List<GetModelNameResponse> findByModelNameContaining (String modelName);

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.car.responses.GetStatusResponse(c.status,c.id" +
            ",c.modelName) from Car c where c.status= :status")
    List<GetStatusResponse> getStatus(String status);

    boolean existsCarByPlate(String plate);
}
