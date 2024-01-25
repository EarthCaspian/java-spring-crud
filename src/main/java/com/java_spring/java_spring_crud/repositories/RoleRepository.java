package com.java_spring.java_spring_crud.repositories;

import com.java_spring.java_spring_crud.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

    RoleEntity findByName(String name);

}
