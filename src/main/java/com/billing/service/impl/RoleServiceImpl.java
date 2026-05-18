package com.billing.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.billing.dto.RoleDTO;
import com.billing.entity.Role;
import com.billing.repository.RoleRepository;
import com.billing.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
		
			 private RoleRepository
		     roleRepository;
		
		public RoleServiceImpl(
		     RoleRepository roleRepository) {
		
		 this.roleRepository =
		         roleRepository;
		}
		
		@Override
		public RoleDTO createRole(
		     RoleDTO roleDTO) {
		
		 Role role = Role.builder()
		         .roleName(
		                 roleDTO.getRoleName())
		         .build();
		
		 Role savedRole =
		         roleRepository.save(role);
		
		 return RoleDTO.builder()
		         .id(savedRole.getId())
		         .roleName(
		                 savedRole.getRoleName())
		         .build();
		}
		
		@Override
		public RoleDTO getRoleById(
		     Long id) {
		
		 Role role =
		         roleRepository.findById(id)
		         .orElseThrow(() ->
		                 new RuntimeException(
		                         "Role Not Found"));
		
		 return RoleDTO.builder()
		         .id(role.getId())
		         .roleName(
		                 role.getRoleName())
		         .build();
		}
		
		@Override
		public List<RoleDTO>
		getAllRoles() {
		
		 return roleRepository.findAll()
		         .stream()
		         .map(role ->
		                 RoleDTO.builder()
		                 .id(role.getId())
		                 .roleName(
		                         role.getRoleName())
		                 .build())
		         .collect(Collectors.toList());
		}
		
		@Override
		public RoleDTO updateRole(
		     Long id,
		     RoleDTO roleDTO) {
		
		 Role role =
		         roleRepository.findById(id)
		         .orElseThrow(() ->
		                 new RuntimeException(
		                         "Role Not Found"));
		
		 role.setRoleName(
		         roleDTO.getRoleName());
		
		 Role updatedRole =
		         roleRepository.save(role);
		
		 return RoleDTO.builder()
		         .id(updatedRole.getId())
		         .roleName(
		                 updatedRole.getRoleName())
		         .build();
		}
		
		@Override
		public void deleteRole(
		     Long id) {
		
		 roleRepository.deleteById(id);
		}
}
