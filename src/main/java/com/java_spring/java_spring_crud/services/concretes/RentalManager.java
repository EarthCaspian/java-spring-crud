package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
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
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.AddRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.DeleteRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.GetRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.requests.UpdateRentalRequest;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse;
import com.java_spring.java_spring_crud.services.rules.RentalBusinessRule;
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
    private final MessageService messageService;
    private final RentalBusinessRule rentalBusinessRule;

    @Override
    public Result add(AddRentalRequest request) {

        rentalBusinessRule.checkStartDate(request.getStart_date());
        rentalBusinessRule.checkEndDate(request.getStart_date(),request.getEnd_date());
        rentalBusinessRule.checkRentalPeriod(request.getStart_date(),request.getEnd_date());

        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);

        Customer customer = customerService.getById(request.getCustomer_id());
        rental.setCustomer(customer);

        Car car = carService.getById(request.getCar_id());
        rental.setCar(car);

        Location location = locationService.getById(request.getLocation_id());
        rental.setLocation(location);

        rentalRepository.save(rental);
        return new SuccessResult(messageService.getMessage(Messages.Rental.rentalAddSuccess));
    }

    @Override
    public Result deleteById(DeleteRentalRequest request) {
        rentalBusinessRule.existsRentalById(request.getId());
        rentalRepository.deleteById(request.getId());
        return new SuccessResult(messageService.getMessage(Messages.Rental.rentalDeleteSuccess));
    }

    @Override
    public Result update(UpdateRentalRequest request) {

        rentalBusinessRule.checkStartDate(request.getStart_date());
        rentalBusinessRule.checkEndDate(request.getStart_date(),request.getEnd_date());
        rentalBusinessRule.checkRentalPeriod(request.getStart_date(),request.getEnd_date());

        rentalBusinessRule.existsRentalById(request.getId());

        Rental rentalToUpdate = this.modelMapperService.forRequest().map(request,Rental.class);

        Customer customer = customerService.getById(request.getCustomer_id());
        rentalToUpdate.setCustomer(customer);

        Car car = carService.getById(request.getCar_id());
        rentalToUpdate.setCar(car);

        rentalToUpdate.setStart_date(request.getStart_date());
        rentalToUpdate.setEnd_date(request.getEnd_date());

        Location location = locationService.getById(request.getLocation_id());
        rentalToUpdate.setLocation(location);

        rentalRepository.save(rentalToUpdate);
        return new SuccessResult(messageService.getMessage(Messages.Rental.rentalUpdateSuccess));
    }

    @Override
    public Rental getById(GetRentalRequest request) {
        return rentalRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException(Messages.Rental.rentalNotFoundMessage));
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
