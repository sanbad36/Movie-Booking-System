package com.sanket.MovieBookingApplication_LLD;

import com.sanket.MovieBookingApplication_LLD.controller.*;
import com.sanket.MovieBookingApplication_LLD.dtos.CreateUserRequestDto;
import com.sanket.MovieBookingApplication_LLD.models.Language;
import com.sanket.MovieBookingApplication_LLD.models.SeatType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
@SpringBootApplication
public class MovieBookingApplicationLldApplication implements CommandLineRunner {

	private UserController userController;
	private CityController cityController;
	private TheaterController theaterController;
	private ShowController showController;
	private TicketController ticketController;



		public MovieBookingApplicationLldApplication(UserController userController,
													 CityController cityController,
													 TheaterController theaterController,
													 ShowController showController,
													 TicketController ticketController) {
			this.userController = userController;
			this.cityController = cityController;
			this.theaterController = theaterController;
			this.showController = showController;
			this.ticketController = ticketController;
		}

		public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplicationLldApplication.class, args);
	}



		@Override
		public void run(String... args) throws Exception {

			CreateUserRequestDto requestDto =new CreateUserRequestDto();
			requestDto.setEmail("Sanket@gmail.com");

			this.userController.CreateUser(requestDto);
			this.cityController.addCity("Nashik");
			this.theaterController.createTheater("PVR","Gangapur Road", 1L);
			this.theaterController.addAuditorium(1L, "Auditorium_1", 120);

			Map<SeatType, Integer> seatsForAuditorium = new HashMap<>();
			seatsForAuditorium.put(SeatType.GOLD,20);
			seatsForAuditorium.put(SeatType.SILVER, 50);
			seatsForAuditorium.put(SeatType.PLATINUM, 25);
			seatsForAuditorium.put(SeatType.VIP, 25);

			this.theaterController.addSeats(1L,seatsForAuditorium);

			this.showController.createShow(0L,new Date(), new Date(), 1L, null, Language.ENGLISH );

//			this.ticketController.bookTicket(1L,Arrays.asList(3L,4L,5L), 1L);

			TicketBookingRunner ticketBookRunner1 = new TicketBookingRunner(
					this.ticketController,
					1L,
					List.of(58L, 59L),
					1L
			);

			TicketBookingRunner ticketBookRunner2 = new TicketBookingRunner(
					this.ticketController,
					1L,
					List.of(1L, 2L, 3L),
					1L
			);

			Thread t1 = new Thread(ticketBookRunner1);
			Thread t2 = new Thread(ticketBookRunner2);
			t1.start();
			t2.start();
		}

}