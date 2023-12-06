package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.repositories.RentalRepository;
import com.java_spring.java_spring_crud.services.abstracts.RentalService;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.AddRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.DeleteRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.GetRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.UpdateRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController
{
    private final RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<GetAllRentalResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public Rental getById(GetRentalRequest request) {
        return rentalService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddRentalRequest request) {
        rentalService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteRentalRequest request) {
        rentalService.deleteById(request);
    }

    @PutMapping("{id}")
    public void update(@Valid @RequestBody UpdateRentalRequest request) {
        rentalService.update(request);
    }

    @GetMapping("getByDate")
    public List<GetRentalByDateResponse> getByDate(@RequestParam LocalDate date) {
       return rentalService.getByDate(date);
    }
}
