package com.billing.util;

import com.billing.dto.UserDTO;
import com.billing.entity.User;

public class MapperUtil {

	private MapperUtil() {
    }

    public static UserDTO mapToUserDTO(
            User user) {

        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phoneNumber(
                        user.getPhoneNumber())
                .status(user.getStatus())
                .build();
    }

    public static User mapToUserEntity(
            UserDTO dto) {

        return User.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(
                        dto.getPhoneNumber())
                .status(dto.getStatus())
                .build();
    }
}
