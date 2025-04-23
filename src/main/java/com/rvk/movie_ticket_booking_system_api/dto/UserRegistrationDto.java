package com.rvk.movie_ticket_booking_system_api.dto;

import com.rvk.movie_ticket_booking_system_api.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRegistrationDto(
        @NotNull
        String userName,
        @NotNull @Email
        String email,
        @NotNull
        String phoneNumber,
        @NotNull
        String password,
        @NotNull
        Role userRole,
        @NotNull
        LocalDate dateOfBirth
) {
}
