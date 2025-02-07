package com.springsecurity.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionResponse {
    private String message;
    private String error;
    private LocalDateTime timestamp;
}
