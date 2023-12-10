package com.example.rent_a_car_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> methodValidations(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<String, String>();
        exception.getBindingResult().getFieldErrors().forEach(fieldErrors ->
                errors.put(fieldErrors.getField(), fieldErrors.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> businessExceptionHandle(Exception exception) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("error", exception.getLocalizedMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
