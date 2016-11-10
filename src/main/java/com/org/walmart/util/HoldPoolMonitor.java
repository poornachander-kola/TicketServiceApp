package com.org.walmart.util;

import java.util.HashSet;
import java.util.Set;

import com.org.walmart.model.Theatre;
/*
 * class to have thread to monitor hold pool for 
 * every few seconds to delete expired hoold objects 
 */
public class HoldPoolMonitor implements Runnable{
	Theatre theatre;
	Set previousHoldSet;
	
	public HoldPoolMonitor(){
		
	}
	public HoldPoolMonitor(Theatre theatre) {
		super();
		this.theatre = theatre;
	}
	@Override
	public void run() {		
		theatre.getHoldRequests().keySet().removeAll(previousHoldSet); //compares two sets and deletes hold objects which are older than time set
		previousHoldSet = theatre.getHoldRequests().keySet(); // replaces previosHoldset with new set.
	}	
}
