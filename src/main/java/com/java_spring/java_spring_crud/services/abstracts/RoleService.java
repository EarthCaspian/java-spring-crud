package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.services.dtos.RoleDto;

import javax.management.relation.Role;
import java.util.List;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);
    void deleteRole(Integer id);

    RoleEntity findByName(String name);

    List<RoleEntity> getAll();
}
