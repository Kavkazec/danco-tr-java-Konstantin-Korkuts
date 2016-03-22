package com.danco.training.dbentity;

import java.util.Date;

public class Settlement extends BaseEntity{
	
	private static final long serialVersionUID = -1536940568158081361L;
	private int guestId;
	private int roomId;
	private Date dateOfArrival;
	private Date dateOfDeparture;
	
	public Settlement(){
		super();
	}
	
	public Settlement(int id, int guestId, int roomId, Date dateOfArrival, Date dateOfDeparture){
		super(id);
		this.guestId = guestId;
		this.roomId = roomId;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	
	
}
