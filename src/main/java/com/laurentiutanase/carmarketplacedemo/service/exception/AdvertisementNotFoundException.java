package com.laurentiutanase.carmarketplacedemo.service.exception;

public class AdvertisementNotFoundException extends RuntimeException {

    public AdvertisementNotFoundException(final String message){
        super(message);
    }
}
