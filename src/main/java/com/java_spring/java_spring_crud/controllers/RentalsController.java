package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.core.utilities.results.Result;
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
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
@CrossOrigin
@Data
public class RentalsController
{
    private final RentalService rentalService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public Result add(@RequestBody @Valid AddRentalRequest request) {
        return rentalService.add(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("{id}")
    public Result update(@Valid @RequestBody UpdateRentalRequest request) {
        return rentalService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public Rental getById(GetRentalRequest request) {
        return rentalService.getById(request);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("{id}")
    public Result deleteById(DeleteRentalRequest request) {
        return rentalService.deleteById(request);
    }

    @GetMapping("getByDate")
    public List<GetRentalByDateResponse> getByDate(@RequestParam LocalDate date) {
       return rentalService.getByDate(date);
    }
}
