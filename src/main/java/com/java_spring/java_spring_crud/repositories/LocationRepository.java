package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Location;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength;
import com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByManagerResponse" +
            "(e.id,l.address,l.name) from Location l join l.managerId e where e.id= :id")
    List<GetLocationByManagerResponse> getByManager(int id);

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.location.responses.GetLocationByAddressLength" +
            "(l.address,l.name) from Location l where length(l.address) > :length")
    List<GetLocationByAddressLength> getByAddressLength(int length);

}
