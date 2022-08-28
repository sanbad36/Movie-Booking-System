package com.sanket.MovieBookingApplication_LLD.services;

import com.sanket.MovieBookingApplication_LLD.models.*;
import com.sanket.MovieBookingApplication_LLD.repositories.AuditoriumRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.ShowRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {

    private ShowRepository showRepository;
    private AuditoriumRepository auditoriumRepository;
    private ShowSeatRepository showSeatRepository;
    @Autowired
    public ShowService(ShowRepository showRepository,
                       AuditoriumRepository auditoriumRepository,
                       ShowSeatRepository showSeatRepository){
        this.showRepository = showRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Shows createShow(Long movieId, Date startTime, Date endTime, Long auditoriumId, Map<SeatType, Integer> seatPricing, Language language) {

        Shows shows = new Shows();
        shows.setLanguage(language);
        shows.setStartTime(startTime);
        shows.setEndTime(endTime);

        Auditorium auditorium = this.auditoriumRepository.findById(auditoriumId).get();
        shows.setAuditorium(auditorium);
        Shows savedShow = showRepository.save(shows);
        List<ShowSeat> showSeatList = new ArrayList<>();

        for(Seats seats : auditorium.getSeats()){

            ShowSeat showSeat = new ShowSeat();
            showSeat.setShows(savedShow);
            showSeat.setSeats(seats);
            showSeat.setState(ShowSeatsState.AVAILABLE);
            showSeatList.add(showSeatRepository.save(showSeat));
        }
        shows.setShowSeatList(showSeatList);
        return showRepository.save(shows);
    }
}
