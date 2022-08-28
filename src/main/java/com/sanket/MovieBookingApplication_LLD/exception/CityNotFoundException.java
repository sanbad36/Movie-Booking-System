package com.sanket.MovieBookingApplication_LLD.exception;

import com.sanket.MovieBookingApplication_LLD.models.City;

public class CityNotFoundException extends Exception{
    public CityNotFoundException(String message){
        super(message);
    }
}
