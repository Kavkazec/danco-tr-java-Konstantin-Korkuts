package com.danco.training.Model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomModel.
 */
public class RoomModel{
	
	/** The number. */
	private int number;
	
	/** The capacity. */
	private int capacity;
	
	/** The number of stars. */
	private int numberOfStars;
	
	/** The coast. */
	private int coast;
	
	/** The is free room. */
	private boolean isFreeRoom = false;
	
	/** The is on repair. */
	private boolean isOnRepair = false;
	
	/** The Constant SEMICOLON. */
	private static final char SEMICOLON = ';'; 
	
	/** The guests. */
	private List<GuestModel> guests = new ArrayList<GuestModel>();
	
	/**
	 * Checks if is on repair.
	 *
	 * @return true, if is on repair
	 */
	public boolean isOnRepair() {
		if(guests.isEmpty()){
			System.out.println("Status is changed!");
		}	else System.out.println("Evict!");
		return isOnRepair;
	}
	
	/**
	 * Sets the on repair.
	 *
	 * @param isOnRepair the new on repair
	 */
	public void setOnRepair(boolean isOnRepair){
		this.isOnRepair = isOnRepair;
	}
	
	/**
	 * Instantiates a new room model.
	 *
	 * @param number the number
	 * @param capacity the capacity
	 * @param numberOfStars the number of stars
	 * @param coast the coast
	 */
	public RoomModel(int number, int capacity, int numberOfStars, int coast) {
		this.number = number;
		this.capacity = capacity;
		this.numberOfStars = numberOfStars;
		this.coast = coast;	
	}
	
	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
		return guests;
	}
	
	/**
	 * Sets the guests.
	 *
	 * @param guests the new guests
	 */
	public void setGuests(GuestModel guests) {
		if(this.guests.size() < capacity){
			this.guests.add(guests);
		} else System.out.println("Room is full of guests");
	}
	
	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Gets the number of stars.
	 *
	 * @return the number of stars
	 */
	public int getNumberOfStars() {
		return numberOfStars;
	}
	
	/**
	 * Sets the coast.
	 *
	 * @param coast the new coast
	 */
	public void setCoast(int coast){
		this.coast = coast;
	}
	
	/**
	 * Gets the coast.
	 *
	 * @return the coast
	 */
	public int getCoast() {
		return coast;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status){
		isFreeRoom = status;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public boolean getStatus() {
		if(guests.size() < capacity){
			isFreeRoom = false;
		} else isFreeRoom= true;
		return isFreeRoom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(number)+SEMICOLON);
		sb.append(Integer.toString(capacity)+SEMICOLON);
		sb.append(Integer.toString(numberOfStars)+SEMICOLON);
		sb.append(Integer.toString(coast)+SEMICOLON);
		sb.append(Boolean.toString(isFreeRoom)+SEMICOLON);
		return sb.toString();
	}
}
