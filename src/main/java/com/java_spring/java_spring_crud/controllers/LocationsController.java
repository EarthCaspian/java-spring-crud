package com.java_spring.java_spring_crud.controllers;

import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.abstracts.LocationService;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
@CrossOrigin
@Data
public class LocationsController
{
    private final LocationService locationService;


    @GetMapping("/getAll")
    public List<String> getAll() {
        return locationService.getAll();
    }

    @GetMapping("{id}")
    public Location getById(GetLocationRequest request) {
       return locationService.getById(request);
    }

    @PostMapping
    public Result add(@RequestBody @Valid AddLocationRequest request) {
       return locationService.add(request);
    }

    @DeleteMapping("{id}")
    public Result deleteById(DeleteLocationRequest request) {
        return locationService.deleteById(request);
    }

    @PutMapping("{id}")
    public Result update(@Valid @RequestBody UpdateLocationRequest request) {
        return locationService.update(request);
    }

    @GetMapping("getByManager")
    public List<GetLocationByManagerResponse> getLocationByManagerResponses (@RequestParam int id) {
        return locationService.getByManager(id);
    }

    @GetMapping("getByAddressLength")
    public List<GetLocationByAddressLength> getLocationByAddressLengths(@RequestParam int length) {
        return locationService.getByAddressLength(length);
    }
}
