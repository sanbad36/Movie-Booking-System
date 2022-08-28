package com.sanket.MovieBookingApplication_LLD.controller;

import com.sanket.MovieBookingApplication_LLD.models.City;
import com.sanket.MovieBookingApplication_LLD.services.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    public City addCity(String name){

        return this.cityService.addCity(name);
    }

}
