package com.rvk.movie_ticket_booking_system_api.utility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse<T> {
    private int errorCode;
    private String message;
    private T error;
}
