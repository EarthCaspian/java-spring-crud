package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import com.java_spring.java_spring_crud.repositories.LocationRepository;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.abstracts.LocationService;
import com.java_spring.java_spring_crud.services.dtos.location.requests.AddLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.DeleteLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.GetLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.requests.UpdateLocationRequest;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationManager implements LocationService {

    private final LocationRepository locationRepository;
    private final EmployeeService employeeService;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddLocationRequest request) {
        if (request.getAddress().length() > 50)
            throw new RuntimeException("Adres çok uzun!");

        Location location = new Location();
        location.setAddress(request.getAddress());
        location.setName(request.getName());
        Employee employee = employeeService.getById(request.getManagerId());
        location.setManagerId(employee);
        locationRepository.save(location);
    }

    @Override
    public void deleteById(DeleteLocationRequest request) {
        Location locationToDelete = locationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Şube bulunamadı."));
        locationRepository.delete(locationToDelete);
    }

    @Override
    public void update(UpdateLocationRequest request) {
        Location locationToUpdate = locationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Şube bulunamadı."));
        locationToUpdate.setAddress(request.getAddress());
        locationToUpdate.setName(request.getName());
        Employee employee = employeeService.getById(request.getManagerId());
        locationToUpdate.setManagerId(employee);
        locationRepository.save(locationToUpdate);
    }

    @Override
    public Location getById(GetLocationRequest request) {
        return locationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Şube bulunamadı."));
    }

    @Override
    public List<String> getAll() {
        return locationRepository.findAll().stream()
                .map(Location::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetLocationByManagerResponse> getByManager(int id) {

        return locationRepository.getByManager(id).stream()
                .map((location) -> new GetLocationByManagerResponse(location.getManagerId(), location.getName(),
                        location.getAddress())).toList();
    }

    @Override
    public List<GetLocationByAddressLength> getByAddressLength(int length) {
        return locationRepository.getByAddressLength(length);
    }

    @Override
    public Location getById(int id) {
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasyon bulunamadı."));
    }
}
