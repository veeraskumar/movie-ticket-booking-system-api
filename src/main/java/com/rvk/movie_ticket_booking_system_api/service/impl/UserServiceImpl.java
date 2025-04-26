package com.rvk.movie_ticket_booking_system_api.service.impl;

import com.rvk.movie_ticket_booking_system_api.dto.TheaterInput;
import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.Theater;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
import com.rvk.movie_ticket_booking_system_api.enums.Role;
import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.mapping.RegistrationMapping;
import com.rvk.movie_ticket_booking_system_api.repository.TheaterRepository;
import com.rvk.movie_ticket_booking_system_api.repository.UserDetailsRepository;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final RegistrationMapping registrationMapping;

    public UserDetails registerUser(UserRegistrationDto userRegistrationDto) {

        if (userDetailsRepository.existsByEmail(userRegistrationDto.email()))
            throw new EmailException("This Mail is already Exist ---> " + userRegistrationDto.email() + " !!");

        if (Role.USER == userRegistrationDto.userRole())
            return userDetailsRepository.save(registrationMapping.registrationUser(userRegistrationDto));

        if (Role.THEATER_OWNER == userRegistrationDto.userRole())
            return userDetailsRepository.save(registrationMapping.registrationTheaterOwner(userRegistrationDto));

        return null;
    }
}