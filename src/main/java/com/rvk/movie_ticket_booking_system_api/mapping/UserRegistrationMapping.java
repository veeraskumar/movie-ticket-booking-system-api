package com.rvk.movie_ticket_booking_system_api.mapping;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.dto.UserResponseDto;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.User;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
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
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
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
        theaterOwner.setCreateAt(System.currentTimeMillis());
        theaterOwner.setUpdateAt(System.currentTimeMillis());
        return theaterOwner;
    }

    public UserResponseDto responseDto(UserDetails userDetails) {
        return new UserResponseDto(userDetails.getUserId(), userDetails.getUserName(), userDetails.getEmail(),
                userDetails.getPhoneNumber(), userDetails.getUserRole(), userDetails.getDateOfBirth(), userDetails.getCreateAt(),
                userDetails.getCreateAt());
    }
}
