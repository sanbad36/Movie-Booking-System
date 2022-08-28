package com.sanket.MovieBookingApplication_LLD.repositories;

import com.sanket.MovieBookingApplication_LLD.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
}
