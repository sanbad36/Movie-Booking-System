package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "show_seattype_mapping")
public class ShowSeatType extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "shows_id")
    private Shows shows;

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }
}