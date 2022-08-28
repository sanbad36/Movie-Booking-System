package com.sanket.MovieBookingApplication_LLD.services;


import com.sanket.MovieBookingApplication_LLD.exception.CityNotFoundException;
import com.sanket.MovieBookingApplication_LLD.models.*;
import com.sanket.MovieBookingApplication_LLD.repositories.AuditoriumRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.CityRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.SeatRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TheaterService {

    TheaterRepository theaterRepository;
    CityRepository cityRepository;

    AuditoriumRepository auditoriumRepository;
    SeatRepository seatRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository,
                          CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository,
                            SeatRepository seatRepository ){
        this.theaterRepository = theaterRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
    }
    public Theater createTheater(String name, String address, Long cityId) throws CityNotFoundException {
            Optional<City> optionalCity = cityRepository.findById(cityId);
            if(optionalCity.isEmpty()){
                throw new CityNotFoundException("City with the given Id is not found");
            }

            Theater theater = new Theater();
            theater.setAddress(address);
            theater.setName(name);
            theater.setCity(optionalCity.get());
            Theater savedTheater = theaterRepository.save(theater);

            City cityDb = optionalCity.get();
            if(cityDb.getTheatres() == null){
                cityDb.setTheatres(new ArrayList<>());
            }
            cityDb.getTheatres().add(savedTheater);
            this.cityRepository.save(cityDb);
            return savedTheater;
    }
    public Theater addAuditorium(Long theaterId, String name, int capacity) {
        Theater theater = theaterRepository.findById(theaterId).get();
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        auditorium.setTheater(theater);
        Auditorium savedAuditorium = this.auditoriumRepository.save(auditorium);
        theater.getAuditorium().add(savedAuditorium);
        return theaterRepository.save(theater);
    }


    public void addSeat(Long auditoriumId, Map<SeatType, Integer> seatCountMap){

    Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();

        List<Seats> seatsList = new ArrayList<>();

        for(Map.Entry<SeatType,Integer> entry : seatCountMap.entrySet()){
            for(int i=0;i<entry.getValue(); ++i){
                Seats seats = new Seats();
                seats.setSeatType(entry.getKey());
                seats.setSeatNumber(entry.getKey().toString() + Integer.toString(i+1));
                seatsList.add(seats);
            }
        }

        List<Seats> savedSeats = this.seatRepository.saveAll(seatsList);
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);
    }

}
