package com.example.examenjava.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({PaymentAlreadyCancelledException.class,
    PaymentNotFoundException.class,
    InvalidStatusException.class,
    InvalidTypeException.class})
    public ResponseEntity handle(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
