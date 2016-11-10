package com.org.walmart.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.org.walmart.model.SeatHold;
import com.org.walmart.service.TicketService;
import com.org.walmart.service.TicketServiceImpl;

/**
 * The Rest service class for TicketServiceApp
 * @Author Poorna
 * 
 */

@Path("/TicketServices")
public class TicketServices {

	TicketService ticketService;

	public TicketServices(){
		ticketService = new TicketServiceImpl();
	}


	/**
	 * Find all available seats in Theatre which are not resevred or hold
	 * return a number 
	 */
	@GET
	@Path("/availableSeats")
	@Produces(MediaType.APPLICATION_JSON)
	public int seatsAvailableService() {
		return ticketService.numSeatsAvailable();
	}

	/**
	 * Finds best seats and holds 
	 * return a seatHold which contains holdId, number of seats and SeatIds
	 */
	@POST
	@Path("/holdSeats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SeatHold findAndHoldSeatsService(int numSeats, String customerEmail) {
		return ticketService.findAndHoldSeats(numSeats, customerEmail);
	}

	/**
	 * Service helps in revering the seats held by hold service.
	 * returns reserveId
	 */
	@POST
	@Path("/reserveSeats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String reserveSeatService(String seatHoldId, String customerEmail) {
		return ticketService.reserveSeats(seatHoldId, customerEmail);
	}
}