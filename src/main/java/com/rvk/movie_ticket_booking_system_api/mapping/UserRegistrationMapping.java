package com.rvk.movie_ticket_booking_system_api.mapping;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapping {

    public User registrationUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUserName(userRegistrationDto.userName());
        user.setEmail(userRegistrationDto.email());
        user.setPhoneNumber(userRegistrationDto.phoneNumber());
        user.setPassword(userRegistrationDto.password());
        user.setUserRole(userRegistrationDto.userRole());
        user.setDateOfBirth(userRegistrationDto.dateOfBirth());
        return user;
    }

    public TheaterOwner registrationTheaterOwner(UserRegistrationDto userRegistrationDto) {
        TheaterOwner theaterOwner = new TheaterOwner();
        theaterOwner.setUserName(userRegistrationDto.userName());
        theaterOwner.setEmail(userRegistrationDto.email());
        theaterOwner.setPhoneNumber(userRegistrationDto.phoneNumber());
        theaterOwner.setPassword(userRegistrationDto.password());
        theaterOwner.setUserRole(userRegistrationDto.userRole());
        theaterOwner.setDateOfBirth(userRegistrationDto.dateOfBirth());
        return theaterOwner;
    }

}
