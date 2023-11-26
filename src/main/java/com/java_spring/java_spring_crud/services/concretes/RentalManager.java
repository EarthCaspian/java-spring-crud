package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.repositories.CarRepository;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.repositories.LocationRepository;
import com.java_spring.java_spring_crud.repositories.RentalRepository;
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
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final LocationRepository locationRepository;

    public RentalManager(RentalRepository rentalRepository, CustomerRepository customerRepository,
                         CarRepository carRepository, LocationRepository locationRepository) {
        this.rentalRepository = rentalRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void add(AddRentalRequest request) {
        if (request.getStart_date().isBefore(LocalDate.now()) || request.getEnd_date().isBefore(LocalDate.now()))
            throw new RuntimeException("Yeni kiralama tarih aralıkları geçmişte olamaz.");

        Rental rental = new Rental();
        Customer customer = customerRepository.findById(request.getCustomer_id()).get();
        rental.setCustomer(customer);
        Car car = carRepository.findById(request.getCar_id()).get();
        rental.setCar(car);
        Location location = locationRepository.findById(request.getLocation_id()).get();
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
        Customer customer = customerRepository.findById(request.getCustomer_id()).get();
        rentalToUpdate.setCustomer(customer);
        Car car = carRepository.findById(request.getCar_id()).get();
        rentalToUpdate.setCar(car);
        rentalToUpdate.setStart_date(request.getStart_date());
        rentalToUpdate.setEnd_date(request.getEnd_date());
        Location location = locationRepository.findById(request.getLocation_id()).get();
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
        List<Rental> rentalList = rentalRepository.findAll();
        List<GetAllRentalResponse> rentalResponses = new ArrayList<>();
        rentalList.stream().forEach(x -> {
            GetAllRentalResponse rentalResponseDto = new GetAllRentalResponse();
            rentalResponseDto.setId(x.getId());
            rentalResponseDto.setStart_date(x.getStart_date());
            rentalResponseDto.setEnd_date(x.getEnd_date());
            rentalResponses.add(rentalResponseDto);
        });
        return rentalResponses;
    }

    @Override
    public List<GetRentalByDateResponse> getByDate(LocalDate date) {
        return rentalRepository.getByDate(date);
    }


}
