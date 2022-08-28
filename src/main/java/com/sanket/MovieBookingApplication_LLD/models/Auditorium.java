package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Seats> seats;
    private int capacity;


    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;
    @ManyToOne
    private Theater theater;


}
