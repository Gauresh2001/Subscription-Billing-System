package com.billing.service;

import java.util.List;

import com.billing.dto.RoleDTO;

public interface RoleService {
	  RoleDTO createRole(RoleDTO roleDTO);

	    RoleDTO getRoleById(Long id);

	    List<RoleDTO> getAllRoles();

	    RoleDTO updateRole(Long id,RoleDTO roleDTO);

	    void deleteRole(Long id);
}
