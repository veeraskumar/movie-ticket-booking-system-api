package com.rvk.movie_ticket_booking_system_api.service;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;

public interface UserService {

    public UserDetails registerUser(UserRegistrationDto userRegistrationDto);

}
