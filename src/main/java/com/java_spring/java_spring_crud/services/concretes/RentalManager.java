package com.java_spring.java_spring_crud.services.concretes;

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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final LocationService locationService;

    public RentalManager(RentalRepository rentalRepository, CustomerService customerService, CarService carService, LocationService locationService) {
        this.rentalRepository = rentalRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.locationService = locationService;
    }

    @Override
    public void add(AddRentalRequest request) {
        if (request.getStart_date().isBefore(LocalDate.now()) || request.getEnd_date().isBefore(LocalDate.now()))
            throw new RuntimeException("Yeni kiralama tarih aralıkları geçmişte olamaz.");

        Rental rental = new Rental();
        Customer customer = customerService.getById(request.getCustomer_id());
        rental.setCustomer(customer);
        Car car = carService.getById(request.getCar_id());
        rental.setCar(car);
        Location location = locationService.getById(request.getLocation_id());
        rental.setLocation(location);
        rental.setStart_date(request.getStart_date());
        rental.setEnd_date(request.getEnd_date());
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
        /*List<Rental> rentalList = rentalRepository.findAll();
        List<GetAllRentalResponse> rentalResponses = new ArrayList<>();
        rentalList.stream().forEach(x -> {
            GetAllRentalResponse rentalResponseDto = new GetAllRentalResponse();
            rentalResponseDto.setId(x.getId());
            rentalResponseDto.setStart_date(x.getStart_date());
            rentalResponseDto.setEnd_date(x.getEnd_date());
            rentalResponses.add(rentalResponseDto);
        });
        return rentalResponses;*/
        return rentalRepository.getAll();
    }

    @Override
    public List<GetRentalByDateResponse> getByDate(LocalDate date) {
        return rentalRepository.getByDate(date);
    }


}
