package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query("Select new com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse(b.id,b.name)" +
            "from Brand b Where b.name= :name")
    List<GetListBrandResponse> findByName(String name);

    List<Brand> findByNameStartsWith(String name);

    boolean existsByName(String name);
}
