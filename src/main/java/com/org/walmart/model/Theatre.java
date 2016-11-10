package com.org.walmart.model;

import java.util.HashMap;
import com.org.walmart.util.Constants;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Pojo bean class for Theatre
 * @author Poorna
 *
 */
public class Theatre {

	private int allSeats;
	private ConcurrentHashMap<Integer, Seat> reservedOrHeldSeats = new ConcurrentHashMap<>(); //Didn't use concurrenthashmap as we need treeset for ordered seat number
	private ConcurrentHashMap<String, SeatHold> holdRequests =  new ConcurrentHashMap<>();
	
	public Theatre(){
		this.allSeats = Constants.NUMBER_OF_ROWS*Constants.NUMBER_OF_COLOMNS; // Presumed to have seats set to 100, however this can be modified form properties file.
	}

	public int getAvailableSeats() {
		return allSeats - this.getReservedOrHeldSeats().size();
	}
	public int getAllSeats() {
		return allSeats;
	}

	public void setAllSeats(int allSeats) {
		this.allSeats = allSeats;
	}

	public ConcurrentHashMap<Integer, Seat> getReservedOrHeldSeats() {
		return reservedOrHeldSeats;
	}

	public void setreservedOrHeldSeats(ConcurrentHashMap<Integer, Seat> reservedOrHeldSeats) {
		this.reservedOrHeldSeats = reservedOrHeldSeats;
	}

	public ConcurrentHashMap<String, SeatHold> getHoldRequests() {
		return holdRequests;
	}

	public void setHoldRequests(ConcurrentHashMap<String, SeatHold> holdRequests) {
		this.holdRequests = holdRequests;
	}

	public void setReservedOrHeldSeats(ConcurrentHashMap<Integer, Seat> reservedOrHeldSeats) {
		this.reservedOrHeldSeats = reservedOrHeldSeats;
	}


}