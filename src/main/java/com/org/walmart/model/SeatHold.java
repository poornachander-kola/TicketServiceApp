package com.org.walmart.model;

import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pojo bean class for Seat
 * @author Poorna
 *
 */
@XmlRootElement
public class SeatHold {

	private String holdId;
	private String userName;
	private double price;
	private String emailId;
	private	Integer seats;
	private Set seatIds;
	
	/**
	 * default empty constructor
	 */
	public SeatHold() {

	}

	public SeatHold(String holdId, String userName, double price,
			String emailId, Integer seats, Set seatIds) {
		super();
		this.holdId = holdId;
		this.userName = userName;
		this.price = price;
		this.emailId = emailId;
		this.seats = seats;
		this.seatIds = seatIds;
	}


	public String getHoldId() {
		return holdId;
	}

	public void setHoldId(String holdId) {
		this.holdId = holdId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Set getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(Set seatIds) {
		this.seatIds = seatIds;
	}
	
}
