package com.org.walmart.model;

import java.util.HashMap;
import com.org.walmart.util.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pojo for ticket level
 * 
 * @author jon
 *
 */
@XmlRootElement
public class Theatre {

	private int allSeats;
	private ConcurrentHashMap<Integer, Seat> reservedSeats = new ConcurrentHashMap<Integer, Seat>();
	private ConcurrentHashMap<Integer, Seat> heldSeats = new ConcurrentHashMap<Integer, Seat>();
	
	public Theatre(){
		this.allSeats = Constants.NUMBER_OF_ROWS*Constants.NUMBER_OF_COLOMNS;
	}
	public int getAllSeats() {
		return allSeats;
	}

	public void setAllSeats(int allSeats) {
		this.allSeats = allSeats;
	}

	public ConcurrentHashMap<Integer, Seat> getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(ConcurrentHashMap<Integer, Seat> reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public ConcurrentHashMap<Integer, Seat> getHeldSeats() {
		return heldSeats;
	}

	public void setHeldSeats(ConcurrentHashMap<Integer, Seat> heldSeats) {
		this.heldSeats = heldSeats;
	}

}
