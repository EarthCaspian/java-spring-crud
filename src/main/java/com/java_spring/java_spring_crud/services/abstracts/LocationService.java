package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse;

import java.util.List;

public interface LocationService {
    Result add(AddLocationRequest request);
    Result deleteById(DeleteLocationRequest request);
    Result update(UpdateLocationRequest request);
    Location getById(GetLocationRequest request);
    List<String> getAll();
    List<GetLocationByManagerResponse> getByManager(int id);
    List<GetLocationByAddressLength> getByAddressLength(int length);

    Location getById(int id);

}
