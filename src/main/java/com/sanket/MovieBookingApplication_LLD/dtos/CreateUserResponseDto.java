package com.sanket.MovieBookingApplication_LLD.dtos;


import com.sanket.MovieBookingApplication_LLD.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto {
    private User user;
}
