package com.rvk.movie_ticket_booking_system_api.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BuilderResponseStructure{
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder().statusCode(status.value()).message(message).data(data).build();
        return ResponseEntity.status(status).body(responseStructure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> error(HttpStatus status, String message, T data){
        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder().statusCode(status.value()).message(message).data(data).build();
        return ResponseEntity.status(status).body(responseStructure);
    }
}
