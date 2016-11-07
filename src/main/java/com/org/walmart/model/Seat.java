package com.org.walmart.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pojo for ticket level
 * 
 * @author jon
 *
 */
@XmlRootElement
public class Seat {

	private int rowId;
	private int colomnId;
	private int seatId;
	private String status;
	private String reserveId;
	private String holdId;

	
	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getColomnId() {
		return colomnId;
	}

	public void setColomnId(int colomnId) {
		this.colomnId = colomnId;
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
