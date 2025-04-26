package com.rvk.movie_ticket_booking_system_api.dto;

import jakarta.validation.constraints.NotNull;

public record TheaterInput(
        @NotNull String name,
        @NotNull String address,
        @NotNull String city,
        @NotNull String landmark
) {
}
