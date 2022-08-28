package com.sanket.MovieBookingApplication_LLD.repositories;

import com.sanket.MovieBookingApplication_LLD.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    City save(City city);

}
