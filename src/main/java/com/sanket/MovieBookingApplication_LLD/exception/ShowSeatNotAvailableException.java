package com.sanket.MovieBookingApplication_LLD.exception;

import com.sanket.MovieBookingApplication_LLD.repositories.ShowRepository;

public class ShowSeatNotAvailableException extends  Exception{

    public ShowSeatNotAvailableException(String message){
        super(message);
    }
}
