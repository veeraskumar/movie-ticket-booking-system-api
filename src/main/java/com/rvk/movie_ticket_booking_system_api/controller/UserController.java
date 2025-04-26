package com.rvk.movie_ticket_booking_system_api.controller;

import com.rvk.movie_ticket_booking_system_api.dto.TheaterInput;
import com.rvk.movie_ticket_booking_system_api.dto.TheaterOutput;
import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.dto.UserResponseDto;
import com.rvk.movie_ticket_booking_system_api.entity.Theater;
import com.rvk.movie_ticket_booking_system_api.mapping.RegistrationMapping;
import com.rvk.movie_ticket_booking_system_api.service.UserService;
import com.rvk.movie_ticket_booking_system_api.utility.BuilderResponseStructure;
import com.rvk.movie_ticket_booking_system_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/booking-shows")
public class UserController {
    private final UserService userService;
    private final RegistrationMapping registrationMapping;

    @PostMapping("/register-user")
    public ResponseEntity<ResponseStructure<UserResponseDto>> registerUser(@RequestBody @Validated UserRegistrationDto userRegistrationDto) {
        return BuilderResponseStructure
                .success(HttpStatus.CREATED, "Register is successfully added !",
                        registrationMapping.responseDto(userService.registerUser(userRegistrationDto)));
    }
}
