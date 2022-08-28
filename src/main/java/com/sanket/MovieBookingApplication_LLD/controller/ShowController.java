package com.sanket.MovieBookingApplication_LLD.controller;

import com.sanket.MovieBookingApplication_LLD.models.Language;
import com.sanket.MovieBookingApplication_LLD.models.SeatType;
import com.sanket.MovieBookingApplication_LLD.models.Shows;
import com.sanket.MovieBookingApplication_LLD.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class ShowController {

    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService){
        this.showService = showService;
    }

    public Shows createShow(Long movieId,
                             Date StartTime,
                             Date EndTime,
                             Long auditoriumId,
                             Map<SeatType,Integer> seatPricing,
                            Language language

                             ){
        return showService.createShow(movieId, StartTime, EndTime,auditoriumId,seatPricing,language);

    }

}
