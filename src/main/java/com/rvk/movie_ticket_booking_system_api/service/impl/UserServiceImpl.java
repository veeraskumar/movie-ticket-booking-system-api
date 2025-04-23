package com.rvk.movie_ticket_booking_system_api.service.impl;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
import com.rvk.movie_ticket_booking_system_api.enums.Role;
import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.repository.UserDetailsRepository;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import lombok.AllArgsConstructor;
import com.rvk.movie_ticket_booking_system_api.mapping.UserRegistrationMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    @Autowired
    private final UserRegistrationMapping userRegistrationMapping;

    public UserDetails registerUser(UserRegistrationDto userRegistrationDto) {

        if (userDetailsRepository.existsByEmail(userRegistrationDto.email()))
            throw new EmailException("This Mail is already Exist ---> " + userRegistrationDto.email() + " !!");

        if (Role.USER == userRegistrationDto.userRole())
            return userDetailsRepository.save(userRegistrationMapping.registrationUser(userRegistrationDto));

        if (Role.THEATER_OWNER == userRegistrationDto.userRole())
            return userDetailsRepository.save(userRegistrationMapping.registrationTheaterOwner(userRegistrationDto));

        return null;
    }
}