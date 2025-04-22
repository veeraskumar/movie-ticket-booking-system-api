package com.rvk.movie_ticket_booking_system_api.service.impl;

import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.UserDetails;
import com.rvk.movie_ticket_booking_system_api.entity.User;
import com.rvk.movie_ticket_booking_system_api.enums.Role;
import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.repository.UserDetailsRepository;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetails registerUser(UserDetails userDetails) {
        if (userDetailsRepository.exitByEmail(userDetails.getEmail())) {
            throw new EmailException("This Mail is already Exist : " + userDetails.getEmail());
        }
        if (userDetails.getUserRole() == Role.USER) {
            User user = new User();
            user.setUserid(user.getUserid());
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setPassword(userDetails.getPassword());
            user.setUserRole(userDetails.getUserRole());
            user.setDataOfBirth(userDetails.getDataOfBirth());
            user.setCreateAt(userDetails.getCreateAt());
            user.setUpdateAt(userDetails.getUpdateAt());
            return userDetailsRepository.save(user);
        }
        if (userDetails.getUserRole() == Role.THEATER_OWNER) {
            TheaterOwner theaterOwner = new TheaterOwner();
            theaterOwner.setUserid(userDetails.getUserid());
            theaterOwner.setUserName(userDetails.getUserName());
            theaterOwner.setEmail(userDetails.getEmail());
            theaterOwner.setPhoneNumber(userDetails.getPhoneNumber());
            theaterOwner.setPassword(userDetails.getPassword());
            theaterOwner.setUserRole(userDetails.getUserRole());
            theaterOwner.setDataOfBirth(userDetails.getDataOfBirth());
            theaterOwner.setCreateAt(userDetails.getCreateAt());
            theaterOwner.setUpdateAt(userDetails.getUpdateAt());
            return userDetailsRepository.save(theaterOwner);
        }
        return null;
    }
}