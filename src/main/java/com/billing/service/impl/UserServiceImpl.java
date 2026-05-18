package com.billing.service.impl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.billing.dto.UserDTO;
import com.billing.entity.User;
import com.billing.repository.UserRepository;
import com.billing.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDTO createUser(UserDTO dto) {

        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .status(dto.getStatus())
                .build();

        User saved = repository.save(user);

        return mapToDTO(saved);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {

        User user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setStatus(dto.getStatus());

        User updated = repository.save(user);

        return mapToDTO(updated);
    }

    @Override
    public void deleteUser(Long id) {

        repository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .build();
    }
}
