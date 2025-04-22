package com.rvk.movie_ticket_booking_system_api.handler;

import com.rvk.movie_ticket_booking_system_api.exception.EmailException;
import com.rvk.movie_ticket_booking_system_api.utility.BuilderResponseStructure;
import com.rvk.movie_ticket_booking_system_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@AllArgsConstructor
public class EmailExceptionHandler<T> {
    private final BuilderResponseStructure builderResponseStructure;

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<T>> emailExceptionHandlerResponse(EmailException exception){
        return BuilderResponseStructure.error(HttpStatus.BAD_REQUEST, exception.getMessage(), null);
    }

}
