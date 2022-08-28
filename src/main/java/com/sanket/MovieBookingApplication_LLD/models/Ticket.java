package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    // 1 : 1
    // m  :  1
    @ManyToOne
    private User bookedBy;

    // 1 T : 1S
    // M T    :  1S
    @ManyToOne
    private Shows shows;


    // 1 : M
    // 1  : 1  // if no cancellation -> @OneToMany
    @ManyToMany
    private List<ShowSeat> showSeats;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

    public Date getTimeOfBooking() {
        return timeOfBooking;
    }
}

// if there is a conflict of booking, allow the request
// that is booking more seats