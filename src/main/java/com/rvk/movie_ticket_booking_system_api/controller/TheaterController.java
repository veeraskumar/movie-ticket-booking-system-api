package com.rvk.movie_ticket_booking_system_api.controller;

import com.rvk.movie_ticket_booking_system_api.dto.TheaterInput;
import com.rvk.movie_ticket_booking_system_api.dto.TheaterOutput;
import com.rvk.movie_ticket_booking_system_api.mapping.RegistrationMapping;
import com.rvk.movie_ticket_booking_system_api.service.TheaterService;
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
public class TheaterController {

    private final TheaterService theaterService;
    private final RegistrationMapping registrationMapping;

    @PostMapping("/register-Theater")
    public ResponseEntity<ResponseStructure<TheaterOutput>> registerTheater(@RequestBody @Validated TheaterInput theaterInput, @RequestParam String email) {
        return BuilderResponseStructure.success(HttpStatus.CREATED, "Register Theater Object",
                registrationMapping.responseTheaterDto(theaterService.registerTheater(theaterInput, email)));
    }

}
