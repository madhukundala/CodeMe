package com.me.interview.exceptions;

public class ServiceException extends RuntimeException {

    public ServiceException(String errorMessage) {
        super(errorMessage);
    }
}
