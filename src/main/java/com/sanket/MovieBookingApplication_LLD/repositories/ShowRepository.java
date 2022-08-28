package com.sanket.MovieBookingApplication_LLD.repositories;

import com.sanket.MovieBookingApplication_LLD.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Shows,Long> {
}
