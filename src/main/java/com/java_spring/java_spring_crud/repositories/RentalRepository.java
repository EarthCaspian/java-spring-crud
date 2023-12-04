package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Rental;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse;
import com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {


    @Query("Select new com.java_spring.java_spring_crud.services.dtos.rental.responses.GetRentalByDateResponse" +
            "(r.start_date,r.end_date,r.id) from Rental r where r.start_date= :date or r.end_date= :date")
    List<GetRentalByDateResponse> getByDate (LocalDate date);


    @Query("Select new com.java_spring.java_spring_crud.services.dtos.rental.responses.GetAllRentalResponse(r.id," +
            "r.start_date,r.end_date,c.id,ca.id,l.id) from Rental r join r.customer c join r.car ca join r.location l")
    List<GetAllRentalResponse> getAll();
}
