package com.laurentiutanase.carmarketplacedemo.service.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(final String message){
        super(message);
    }
}
