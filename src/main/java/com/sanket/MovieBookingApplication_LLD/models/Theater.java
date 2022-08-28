package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class Theater extends BaseModel {

    private String name;
    private String address;

    @OneToMany(mappedBy = "theater", fetch = FetchType.EAGER)
    private List<Auditorium> auditorium;

    @OneToMany
    private List<Shows> showsList;

    @ManyToOne
    private City city;
}
