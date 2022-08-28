package com.sanket.MovieBookingApplication_LLD.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Setter
@Getter
public class Payment extends BaseModel {
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private double amount;
    private String referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    //  1 : 1
    //  M :  1
    @ManyToOne   // what if the previous payment failed
    private Ticket ticket;

}
