package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse;

import java.util.List;

public interface LocationService {
    void add(AddLocationRequest request);
    void deleteById(DeleteLocationRequest request);
    void update(UpdateLocationRequest request);
    Location getById(GetLocationRequest request);
    List<String> getAll();
    List<GetLocationByManagerResponse> getByManager(int id);
    List<GetLocationByAddressLength> getByAddressLength(int length);

}
