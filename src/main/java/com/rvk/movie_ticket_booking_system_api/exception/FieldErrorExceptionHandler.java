package com.rvk.movie_ticket_booking_system_api.exception;

import com.rvk.movie_ticket_booking_system_api.utility.CustomFieldError;
import com.rvk.movie_ticket_booking_system_api.utility.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Component
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        List<ObjectError> objectErrors = ex.getAllErrors();
        List<CustomFieldError> customFieldErrors = new ArrayList<>();
        for (ObjectError objectError : objectErrors) {
            FieldError fieldError = (FieldError) objectError;
            CustomFieldError customFieldError = CustomFieldError.builder()
                    .fieldName(fieldError.getField())
                    .rejectValue(fieldError.getRejectedValue())
                    .message(fieldError.getDefaultMessage()).build();

            customFieldErrors.add(customFieldError);
        }

        ErrorResponse<List<CustomFieldError>> listErrorResponse = ErrorResponse.<List<CustomFieldError>>builder()
                .message("").error(customFieldErrors)
                .errorCode(HttpStatus.CREATED.value())
                .build();
        return new ResponseEntity<>(listErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
