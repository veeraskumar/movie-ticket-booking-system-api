package com.rvk.movie_ticket_booking_system_api.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ResponseStructure<T> {
    private int statusCode;
    private String message;
    private T data;
}
