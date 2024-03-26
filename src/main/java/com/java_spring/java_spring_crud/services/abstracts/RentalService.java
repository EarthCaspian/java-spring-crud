package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.AddRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.DeleteRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.GetRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.UpdateRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    Result add(AddRentalRequest request);
    Result deleteById(DeleteRentalRequest request);
    Result update(UpdateRentalRequest request);
    Rental getById(GetRentalRequest request);
    List<GetAllRentalResponse> getAll();
    List<GetRentalByDateResponse> getByDate(LocalDate date);
}
