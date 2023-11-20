package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController
{
    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {this.rentalRepository = rentalRepository;}

    @GetMapping
    public List<Rental> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals;
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id) {
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental) {rentalRepository.save(rental);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental rental) {
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setCar(rental.getCar());
        rentalToUpdate.setStart_date(rental.getStart_date());
        rentalToUpdate.setEnd_date(rental.getEnd_date());
        rentalRepository.save(rentalToUpdate);
    }
}
