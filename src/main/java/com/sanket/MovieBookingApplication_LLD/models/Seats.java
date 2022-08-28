package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Seats extends BaseModel{

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
