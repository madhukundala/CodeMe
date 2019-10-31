package com.me.interview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(value
            = ServiceException.class)
    public ResponseEntity<Object> handleServiceExeption(Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getLocalizedMessage();
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> exception(Exception exception) {
        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    /**here we can have our custom exceptions can be thrown with custom messages as per our requirement**/
}
