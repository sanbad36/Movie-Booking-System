package com.sanket.MovieBookingApplication_LLD.services;

import com.sanket.MovieBookingApplication_LLD.exception.ShowSeatNotAvailableException;
import com.sanket.MovieBookingApplication_LLD.models.ShowSeat;
import com.sanket.MovieBookingApplication_LLD.models.ShowSeatsState;
import com.sanket.MovieBookingApplication_LLD.models.Ticket;
import com.sanket.MovieBookingApplication_LLD.models.TicketStatus;
import com.sanket.MovieBookingApplication_LLD.repositories.ShowRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.ShowSeatRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.TicketRepository;
import com.sanket.MovieBookingApplication_LLD.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    private ShowRepository showRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository,
                         ShowSeatRepository showSeatRepository,
                         UserRepository userRepository,
                         ShowRepository showRepository){
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatId, Long userId) throws ShowSeatNotAvailableException {
        List<ShowSeat> showSeatList = showSeatRepository.findByIdIn(showSeatId);
        for(ShowSeat showSeat : showSeatList) {
            if (showSeat.getState() != ShowSeatsState.AVAILABLE) {
                throw new ShowSeatNotAvailableException("Show Seat id: " + showSeat.getId() + "is not available");
            }
        }
        for(ShowSeat showSeat : showSeatList){
            showSeat.setState(ShowSeatsState.LOCKED);
            showSeatRepository.save(showSeat);
        }
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setTimeOfBooking(new Date());
        ticket.setBookedBy(userRepository.findById(userId).get());
        ticket.setShows(showRepository.findById(showId).get());
        ticket.setShowSeats(showSeatList);
        return ticketRepository.save(ticket);
    }
}
