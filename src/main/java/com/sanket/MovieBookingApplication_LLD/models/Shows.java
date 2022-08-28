package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Shows extends BaseModel{

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "shows")
    private List<ShowSeat> showSeatList;

    @OneToMany
    private List<ShowSeatType> showSeatType;

    @Enumerated(EnumType.STRING)
    private Language language;
}
