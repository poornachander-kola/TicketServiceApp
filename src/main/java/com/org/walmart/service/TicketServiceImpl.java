package com.org.walmart.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.org.walmart.model.Seat;
import com.org.walmart.model.SeatHold;
import com.org.walmart.model.Theatre;
import com.org.walmart.util.HoldPoolMonitor;


public class TicketServiceImpl implements TicketService{

	Theatre theatre;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	 
	public TicketServiceImpl(){
		this.theatre = new Theatre();
		 scheduler.scheduleWithFixedDelay(new HoldPoolMonitor(theatre), 10, 60, TimeUnit.SECONDS); //Scheduler to run hold pool monitor thread to run every 60sec
	}
	/*
	 * (non-Javadoc)
	 * @see com.org.walmart.service.TicketService#numSeatsAvailable()
	 * returns all available seats in Theatre which are not resevred or hold
	 */
	@Override
	public int numSeatsAvailable() {
		return theatre.getAvailableSeats();
	}

	/*
	 * (non-Javadoc)
	 * @see com.org.walmart.service.TicketService#findAndHoldSeats(int, java.lang.String)
	 * implementation to find and hold best seats
	 * find and holds best seats and sets seats status to "hold" and returns seatHold object which contains holdId, number of seats and seatIds
	 */
	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		SeatHold seatHold=null;
		synchronized (theatre) {
			if(numSeats>0 && theatre.getAvailableSeats()>numSeats){
				HashSet<Integer> bestSeats = getBestSeats(numSeats);
				
				String holdId = randomIdGenerator();
				seatHold = new SeatHold(holdId, customerEmail, 0.0, customerEmail, numSeats, bestSeats);
				theatre.getHoldRequests().put(holdId, seatHold);
				Iterator<Integer> iterator = bestSeats.iterator();
				while (iterator.hasNext()) {
					Integer seatId = (Integer) iterator.next();
					theatre.getReservedOrHeldSeats().put(seatId, new Seat(seatId, "hold", null, holdId));
				}
			}else{
				System.out.println("seats not available");
			}
		}
		return seatHold;
	}

	/*
	 * Method to find the best available seats. it also searches if we have any seat gap in between reseravtions.
	 * If we have any gaps, it will try to fill out them. It also assumes, that seats in the incremental order are best seats for custiomers.
	 * takes number of seats required as input
	 * returns a unique set of seat objects
	 */
	private HashSet<Integer> getBestSeats(int numSeats) {
		// TODO Auto-generated method stub
		//HashMap<Integer, Seat>  bestSeats =  new HashMap<>();
		HashSet<Integer> bestSeats  = new HashSet<>();
		TreeSet<Integer> keySet = new TreeSet(theatre.getReservedOrHeldSeats().keySet());
		int currentSeatIndex = 0;
		int previousSeatIndex = 0;
		if(!keySet.isEmpty()){
			Iterator<Integer>seatsTreeSetIterator = keySet.iterator();
			while(seatsTreeSetIterator.hasNext()){
				currentSeatIndex = seatsTreeSetIterator.next();
				if((currentSeatIndex - previousSeatIndex)>numSeats){
					break;
				}
				previousSeatIndex = currentSeatIndex;
			}
		}
		for(int i=1; i<=numSeats ; i++){
			//bestSeats.put(++previousSeatIndex, new Seat(previousSeatIndex, "hold",randomIdGenerator("hold") , null));
			bestSeats.add(++previousSeatIndex);
		}
		return bestSeats;
	}

	/*
	 * Method to generate a unique random id for holdid and reserveid
	 */
	private String randomIdGenerator(){
		return UUID.randomUUID().toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.org.walmart.service.TicketService#reserveSeats(java.lang.String, java.lang.String)
	 * This is method helps in revering the seats held by hold service.
	 * takes hold id as input and searches for them in hold pool, if they are in hold pool, commits the reservation in main map and changes status to reserved.
	 */
	@Override
	public String reserveSeats(String seatHoldId, String customerEmail) {
		String reserveId;
		Seat seat;
		if(theatre.getHoldRequests().containsKey(seatHoldId)){
			SeatHold seatHold = theatre.getHoldRequests().get(seatHoldId);
			Iterator<Integer> iterator = seatHold.getSeatIds().iterator();
			reserveId = randomIdGenerator();
			while(iterator.hasNext()){
				seat = theatre.getReservedOrHeldSeats().get(iterator.next());
				seat.setStatus("Reserved");
				seat.setReserveId(reserveId);
			}
			theatre.getHoldRequests().remove(seatHoldId); //Remove hold object from pool once they are reserved.
		}else{
			return "hold request has timed out for holdId "+ seatHoldId;
		}
		return reserveId;
	}
	
	public static void main(String []args){
		// for testing usage
	}

}