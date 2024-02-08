package com.java_spring.java_spring_crud.controllers;


import com.java_spring.java_spring_crud.entities.RoleEntity;
import com.java_spring.java_spring_crud.services.abstracts.RoleService;
import com.java_spring.java_spring_crud.services.dtos.RoleDto;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/roles")
@CrossOrigin
@Data
public class RolesController {

    private final RoleService roleService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> System.out.println("Granted Authority: " + authority.getAuthority()));
        return roleService.createRole(roleDto);
    }

    @DeleteMapping("/delete")
    public void deleteRole(Integer id) {
        roleService.deleteRole(id);
    }

    @GetMapping("/getAll")
    public List<RoleEntity> getAll() {
        return roleService.getAll();
    }
}
