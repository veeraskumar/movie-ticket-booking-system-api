package com.rvk.movie_ticket_booking_system_api.controller;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.dto.UserResponseDto;
import com.rvk.movie_ticket_booking_system_api.mapping.UserRegistrationMapping;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import com.rvk.movie_ticket_booking_system_api.utility.BuilderResponseStructure;
import com.rvk.movie_ticket_booking_system_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/booking-shows")
public class UserController {
    private final UserService userService;
    private final UserRegistrationMapping userRegistrationMapping;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponseDto>> registerUser(@RequestBody @Validated UserRegistrationDto userRegistrationDto) {
        return BuilderResponseStructure
                .success(HttpStatus.CREATED, "Register is successfully added !",
                        userRegistrationMapping.responseDto(userService.registerUser(userRegistrationDto)));
    }
}
