package com.rvk.movie_ticket_booking_system_api.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {

    private final String message;

    public EmailException(String message) {
        this.message = message;
    }
}
