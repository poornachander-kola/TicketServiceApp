package com.org.walmart.service;

import com.org.walmart.model.SeatHold;
import com.org.walmart.model.Theatre;


public class TicketServiceImpl implements TicketService{

	Theatre theatre;
	
	public TicketServiceImpl(){
		this.theatre = new Theatre();
	}

	@Override
	public int numSeatsAvailable() {
		return theatre.getAllSeats()-theatre.getReservedSeats().size();
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

}
