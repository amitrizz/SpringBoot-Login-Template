package com.springsecurity.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionResponse> ExceptionHandler(Exception ex, WebRequest req) {
        CustomExceptionResponse response = new CustomExceptionResponse(ex.getMessage(), req.getDescription(false),
                LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}
