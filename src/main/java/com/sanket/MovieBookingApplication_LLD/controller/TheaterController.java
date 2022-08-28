package com.sanket.MovieBookingApplication_LLD.controller;

import com.sanket.MovieBookingApplication_LLD.exception.CityNotFoundException;
import com.sanket.MovieBookingApplication_LLD.models.SeatType;
import com.sanket.MovieBookingApplication_LLD.models.Theater;
import com.sanket.MovieBookingApplication_LLD.services.TheaterService;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class TheaterController {

    private TheaterService theaterService;

    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }
    public Theater createTheater(String name,String address, Long cityId){

        Theater theater = null;

        try{
           theater =  this.theaterService.createTheater(name, address, cityId);
        }
        catch(CityNotFoundException e){
            System.out.println("Something went wrong");
        }
        return theater;
    }

    public Theater addAuditorium(Long theaterId, String name, int capacity){
        return theaterService.addAuditorium(theaterId,name,capacity);
    }

    public void addSeats(Long auditoriumId,
                         Map<SeatType,Integer> seatCount){
        theaterService.addSeat(auditoriumId,seatCount);
    }
}
