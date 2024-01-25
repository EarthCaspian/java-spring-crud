package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.dtos.RoleDto;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles")
@CrossOrigin
@Data
public class RolesController {

    private final RoleService roleService;

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/add")
    public RoleDto createRole(String name) {
        return roleService.createRole(name);
    }

    @DeleteMapping("/delete")
    public void deleteRole(Integer id) {
        roleService.deleteRole(id);
    }
}
