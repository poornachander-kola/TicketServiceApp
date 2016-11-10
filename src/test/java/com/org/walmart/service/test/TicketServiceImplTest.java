package com.org.walmart.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.org.walmart.model.SeatHold;
import com.org.walmart.service.TicketService;
import com.org.walmart.service.TicketServiceImpl;

public class TicketServiceImplTest {
	TicketService ticketService;

	@Before
	public void setUp() throws Exception {
		this.ticketService =  new TicketServiceImpl();
	}
	
	/*
	 *Test Method to test available service 
	 */
	@Test
	public void testGetAvailableSeats() {
		assertEquals(ticketService.numSeatsAvailable(), 100);
		SeatHold seathold = ticketService.findAndHoldSeats(3, "test@mail.com");	
		assertEquals(ticketService.numSeatsAvailable(), 97);
	}

	/*
	 *Test Method to test find and hold service 
	 */
	@Test
	public void testFindAndHoldSeats() {
		SeatHold seathold = ticketService.findAndHoldSeats(3, "test@mail.com");	
		assertEquals(seathold.getSeatIds().size(), 3);
		System.out.println(seathold.getSeatIds());
	}

	/*
	 *Test Method to test reserve service 
	 */
	@Test
	public void testReserveSeats() {
		SeatHold seathold = ticketService.findAndHoldSeats(4, "test@mail.com");	
		assertEquals(seathold.getSeatIds().size(), 4);
		System.out.println(seathold.getSeatIds());
		assertNotNull(ticketService.reserveSeats(seathold.getHoldId(), "test@mail.com")); // Returns random reservation id
		seathold = ticketService.findAndHoldSeats(100, "test@mail.com");	//we exceed maximum number of seats 100, so it should fail
	}

}
