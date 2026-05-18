package com.billing.controller;
import com.billing.dto.RoleDTO;
import com.billing.service.RoleService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO dto) {

        return service.createRole(dto);
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {

        return service.getAllRoles();
    }
}
