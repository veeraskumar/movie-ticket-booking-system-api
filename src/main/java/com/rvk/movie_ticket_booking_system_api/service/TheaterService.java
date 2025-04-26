package com.rvk.movie_ticket_booking_system_api.service;

import com.rvk.movie_ticket_booking_system_api.dto.TheaterInput;
import com.rvk.movie_ticket_booking_system_api.entity.Theater;

public interface TheaterService {
    public Theater registerTheater(TheaterInput theaterInput, String email);

}
