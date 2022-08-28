package com.sanket.MovieBookingApplication_LLD.services;

import com.sanket.MovieBookingApplication_LLD.models.City;
import com.sanket.MovieBookingApplication_LLD.repositories.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    public City addCity(String name){
        City cityToSave = new City();
        cityToSave.setName(name);
      return this.cityRepository.save(cityToSave);
    }

}
