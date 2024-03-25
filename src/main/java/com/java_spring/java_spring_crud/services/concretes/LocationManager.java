package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import com.java_spring.java_spring_crud.repositories.LocationRepository;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.abstracts.LocationService;
import com.java_spring.java_spring_crud.services.constants.Messages;
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
    private final MessageService messageService;

    @Override
    public Result add(AddLocationRequest request) {
        if (request.getAddress().length() > 50)
            throw new RuntimeException("Adres çok uzun!");

        Location location = this.modelMapperService.forRequest().map(request,Location.class);
        Employee employee = employeeService.getById(request.getManagerId());
        location.setManagerId(employee);
        locationRepository.save(location);
        return new SuccessResult(messageService.getMessage(Messages.Location.locationAddSuccess));
    }

    @Override
    public Result deleteById(DeleteLocationRequest request) {
        Location locationToDelete = locationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Şube bulunamadı."));
        locationRepository.delete(locationToDelete);
        return new SuccessResult(messageService.getMessage(Messages.Location.locationDeleteSuccess));
    }

    @Override
    public Result update(UpdateLocationRequest request) {
        Location locationToUpdate = locationRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Şube bulunamadı."));
        locationToUpdate.setAddress(request.getAddress());
        locationToUpdate.setName(request.getName());
        Employee employee = employeeService.getById(request.getManagerId());
        locationToUpdate.setManagerId(employee);
        locationRepository.save(locationToUpdate);
        return new SuccessResult(messageService.getMessage(Messages.Location.locationUpdateSuccess));
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
