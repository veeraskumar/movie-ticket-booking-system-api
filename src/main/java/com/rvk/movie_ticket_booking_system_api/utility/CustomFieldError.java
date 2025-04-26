package com.rvk.movie_ticket_booking_system_api.utility;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomFieldError {
    String fieldName;
    String message;
    Object rejectValue;
}
