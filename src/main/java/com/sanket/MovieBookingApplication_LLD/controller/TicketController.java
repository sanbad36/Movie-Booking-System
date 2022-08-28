package com.sanket.MovieBookingApplication_LLD.controller;


import com.sanket.MovieBookingApplication_LLD.exception.ShowSeatNotAvailableException;
import com.sanket.MovieBookingApplication_LLD.models.Ticket;
import com.sanket.MovieBookingApplication_LLD.services.TicketService;
import org.springframework.stereotype.Controller;
import java.util.*;
@Controller
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public Ticket bookTicket(
        Long showId,
        List<Long> showSeatId,
        Long userId
    ) throws ShowSeatNotAvailableException {
        return this.ticketService.bookTicket(showId,showSeatId,userId);
    }

}
