package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ShowSeat  extends BaseModel{
    @ManyToOne
    private Shows shows;

    @ManyToOne
    private Seats seats;

    @Enumerated(EnumType.STRING)
    private ShowSeatsState state;

}