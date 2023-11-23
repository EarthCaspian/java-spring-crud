package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;

import java.util.List;

public interface LocationService {
    public void add(AddLocationRequest request);
    public void deleteById(DeleteLocationRequest request);
    public void update(UpdateLocationRequest request);
    public Location getById(GetLocationRequest request);
    public List<String> getAll();

}
