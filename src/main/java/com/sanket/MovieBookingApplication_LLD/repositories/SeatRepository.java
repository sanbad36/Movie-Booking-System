package com.sanket.MovieBookingApplication_LLD.repositories;

import com.sanket.MovieBookingApplication_LLD.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seats,Long> {
}
