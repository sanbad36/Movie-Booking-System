package com.sanket.MovieBookingApplication_LLD.controller;

import com.sanket.MovieBookingApplication_LLD.dtos.CreateUserRequestDto;
import com.sanket.MovieBookingApplication_LLD.dtos.CreateUserResponseDto;
import com.sanket.MovieBookingApplication_LLD.models.User;
import com.sanket.MovieBookingApplication_LLD.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public CreateUserResponseDto CreateUser(CreateUserRequestDto request){

        User savedUser = userService.createUser(request.getEmail());
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        createUserResponseDto.setUser(savedUser);
        return createUserResponseDto;
    }


}
