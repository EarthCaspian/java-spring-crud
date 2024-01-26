package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.repositories.RoleRepository;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.dtos.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private final ModelMapperService modelMapperService;
    private final RoleRepository roleRepository;


    @Override
    public RoleDto createRole(String name) {
        RoleEntity role = new RoleEntity();
        role.setName(name);
        RoleEntity savedRole = roleRepository.save(role);
        return modelMapperService.forResponse().map(savedRole, RoleDto.class);
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleEntity findByName(String name) {
        return roleRepository.findByName(name);
    }
}