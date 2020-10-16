package com.laurentiutanase.carmarketplacedemo.service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message){
        super(message);
    }
}
