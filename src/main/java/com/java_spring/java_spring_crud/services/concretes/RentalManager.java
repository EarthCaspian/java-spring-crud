package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.repositories.LocationRepository;
import com.java_spring.java_spring_crud.repositories.RentalRepository;
import com.java_spring.java_spring_crud.services.abstracts.CarService;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.abstracts.LocationService;
import com.java_spring.java_spring_crud.services.abstracts.RentalService;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.AddRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.DeleteRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.GetRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.UpdateRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final LocationService locationService;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddRentalRequest request) {
        if (request.getStart_date().isBefore(LocalDate.now()) || request.getEnd_date().isBefore(LocalDate.now()))
            throw new RuntimeException("Yeni kiralama tarih aralıkları geçmişte olamaz.");

        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);
        Customer customer = customerService.getById(request.getCustomer_id());
        rental.setCustomer(customer);
        Car car = carService.getById(request.getCar_id());
        rental.setCar(car);
        Location location = locationService.getById(request.getLocation_id());
        rental.setLocation(location);
        rentalRepository.save(rental);
    }

    @Override
    public void deleteById(DeleteRentalRequest request) {
        Rental rentalToDelete = rentalRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Kiralama bulunamadı."));
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public void update(UpdateRentalRequest request) {
        if (request.getStart_date().isBefore(LocalDate.now()) || request.getEnd_date().isBefore(LocalDate.now()))
            throw new RuntimeException("Yeni kiralama tarih aralıkları geçmişte olamaz.");

        Rental rentalToUpdate = rentalRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Kiralama bulunamadı."));
        Customer customer = customerService.getById(request.getCustomer_id());
        rentalToUpdate.setCustomer(customer);
        Car car = carService.getById(request.getCar_id());
        rentalToUpdate.setCar(car);
        rentalToUpdate.setStart_date(request.getStart_date());
        rentalToUpdate.setEnd_date(request.getEnd_date());
        Location location = locationService.getById(request.getLocation_id());
        rentalToUpdate.setLocation(location);
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public Rental getById(GetRentalRequest request) {
        return rentalRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Kiralama bulunamadı."));
    }

    @Override
    public List<GetAllRentalResponse> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public List<GetRentalByDateResponse> getByDate(LocalDate date) {
        return rentalRepository.getByDate(date);
    }


}
