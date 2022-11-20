package com.dika.simplecrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handlerGeneralError(RuntimeException e) {
        return new ResponseEntity<>(
                buildResponse( "1500", "General error, internal server error"),
        HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerNotFound(RuntimeException e) {
        return new ResponseEntity<>(
                buildResponse( "1300", "We cannot find your request source"),
                HttpStatus.NOT_FOUND
        );
    }

    private Map<String, String> buildResponse(String code, String message) {
        Map<String, String> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        return response;
    }
}
