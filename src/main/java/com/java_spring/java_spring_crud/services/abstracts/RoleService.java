package com.java_spring.java_spring_crud.services.abstracts;

import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.services.dtos.RoleDto;

public interface RoleService {

    RoleDto createRole(String name);
    void deleteRole(Integer id);

    RoleEntity findByName(String name);
}
