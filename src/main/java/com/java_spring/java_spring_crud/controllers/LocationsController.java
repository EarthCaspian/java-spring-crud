package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.abstracts.LocationService;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
public class LocationsController
{
    private final LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<String> getAll() {
        return locationService.getAll();
    }

    @GetMapping("{id}")
    public Location getById(GetLocationRequest request) {
       return locationService.getById(request);
    }

    @PostMapping
    public void add(@RequestBody AddLocationRequest request) {
        locationService.add(request);
    }

    @DeleteMapping("{id}")
    public void deleteById(DeleteLocationRequest request) {
        locationService.deleteById(request);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateLocationRequest request) {
        locationService.update(request);
    }

    /*
    @GetMapping
    public List<Location> getAll() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @GetMapping("{id}")
    public Location getById(@PathVariable int id) {return locationRepository.findById(id).orElseThrow();}

    @PostMapping
    public void add(@RequestBody Location location) {locationRepository.save(location);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Location locationToDelete = locationRepository.findById(id).orElseThrow();
        locationRepository.delete(locationToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Location location) {
        Location locationToUpdate = locationRepository.findById(id).orElseThrow();
        locationToUpdate.setName(location.getName());
        locationToUpdate.setAddress(location.getAddress());
        locationRepository.save(locationToUpdate);
    }

     */
}
