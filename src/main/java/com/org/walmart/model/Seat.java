package com.org.walmart.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pojo bean class for Seat
 * @author Poorna
 *
 */
public class Seat {

	private int seatId;
	private String status;
	private String reserveId;
	private String holdId;

	private  Seat() {

	}
	public Seat(int seatId, String status, String reserveId, String holdId) {
		super();
		this.seatId = seatId;
		this.status = status;
		this.reserveId = reserveId;
		this.holdId = holdId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReserveId() {
		return reserveId;
	}

	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}

}