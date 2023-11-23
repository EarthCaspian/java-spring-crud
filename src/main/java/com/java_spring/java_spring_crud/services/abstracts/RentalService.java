package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.AddRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.DeleteRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.GetRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.UpdateRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;

import java.util.List;

public interface RentalService {
    public void add(AddRentalRequest request);
    public void deleteById(DeleteRentalRequest request);
    public void update(UpdateRentalRequest request);
    public Rental getById(GetRentalRequest request);
    public List<GetAllRentalResponse> getAll();
}
