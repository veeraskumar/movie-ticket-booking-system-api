package com.rvk.movie_ticket_booking_system_api.service.impl;

import com.rvk.movie_ticket_booking_system_api.dto.TheaterInput;
import com.rvk.movie_ticket_booking_system_api.entity.Theater;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.enums.Role;
import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.mapping.RegistrationMapping;
import com.rvk.movie_ticket_booking_system_api.repository.TheaterRepository;
import com.rvk.movie_ticket_booking_system_api.repository.UserDetailsRepository;
import com.rvk.movie_ticket_booking_system_api.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TheaterServiceImpl implements TheaterService {
    private final UserDetailsRepository userDetailsRepository;
    private final TheaterRepository theaterRepository;
    private final RegistrationMapping registrationMapping;

    @Override
    public Theater registerTheater(TheaterInput theaterInput, String email) {
        if (userDetailsRepository.existsByEmail(email)) {
            TheaterOwner theaterOwner = (TheaterOwner) userDetailsRepository.findByEmail(email);
            if (Role.THEATER_OWNER == theaterOwner.getUserRole())
                return theaterRepository.save(registrationMapping.registerTheater(theaterInput, theaterOwner));
        }
        throw new EmailException("There is no Theater Owner register under the Email !! ");
    }
}
