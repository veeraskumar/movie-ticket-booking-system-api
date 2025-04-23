package com.rvk.movie_ticket_booking_system_api.dto;

import com.rvk.movie_ticket_booking_system_api.enums.Role;

import java.time.LocalDate;

public record UserRegistrationDto(
        String userName,
        String email,
        String phoneNumber,
        String password,
        Role userRole,
        LocalDate dateOfBirth
) {
}
