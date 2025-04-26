package com.rvk.movie_ticket_booking_system_api.dto;

public record TheaterOutput(
        String theaterId,
        String name,
        String phoneNumber,
        String email,
        String address,
        String city,
        String landmark,
        Long createAt,
        Long updateAt
) {
}
