package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<Theater> theatres;
}
