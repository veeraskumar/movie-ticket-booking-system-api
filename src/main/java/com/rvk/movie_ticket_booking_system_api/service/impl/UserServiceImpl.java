package com.rvk.movie_ticket_booking_system_api.service.impl;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
import com.rvk.movie_ticket_booking_system_api.entity.User;
import com.rvk.movie_ticket_booking_system_api.enums.Role;
import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.repository.UserDetailsRepository;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapping.UserRegistrationMapping;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRegistrationMapping userRegistrationMapping;

    public UserDetails registerUser(UserRegistrationDto userRegistrationDto) {
        if (userDetailsRepository.exitByEmail(userRegistrationDto.email()))
            throw new EmailException("This Mail is already Exist ---> " + userRegistrationDto.email() + " !!");

        if (userRegistrationDto.userRole() == Role.USER)
            userRegistrationMapping.registrationUser(userRegistrationDto);

        if (userRegistrationDto.userRole() == Role.THEATER_OWNER)
            userRegistrationMapping.registrationTheaterOwner(userRegistrationDto);

        return null;
    }
}