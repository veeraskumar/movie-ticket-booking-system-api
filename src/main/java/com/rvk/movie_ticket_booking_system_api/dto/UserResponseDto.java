package com.rvk.movie_ticket_booking_system_api.dto;

import com.rvk.movie_ticket_booking_system_api.enums.Role;

import java.time.LocalDate;

public record UserResponseDto(
        String userId,
        String userName,
        String email,
        String phoneNumber,
        Role userRole,
        LocalDate dateOfBirth,
        long createAt,
        long updateAt
) {
}
