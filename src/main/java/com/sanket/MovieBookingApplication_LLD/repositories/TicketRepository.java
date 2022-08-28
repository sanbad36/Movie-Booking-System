package com.sanket.MovieBookingApplication_LLD.repositories;

import com.sanket.MovieBookingApplication_LLD.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
