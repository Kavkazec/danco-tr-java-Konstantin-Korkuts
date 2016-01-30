package com.danco.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomModel.
 */
public class RoomModel implements Cloneable,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private static final String SEMICOLON = " ; ";
	
	/** The guests. */
	private List<GuestModel> guests = new ArrayList<GuestModel>();
	
	/**
	 * Checks if is on repair.
	 *
	 * @return true, if is on repair
	 */
	public boolean getIsOnRepair() {
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
	
	public void setNumber(int number){
		this.number = number;
	}
	
	/**
	 * Sets the guests.
	 *
	 * @param guests the new guests
	 */
	public void setGuests(GuestModel guests) {
		this.guests.add(guests);
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
	 * Sets the number of stars.
	 *
	 * @param numberOfStars the new number of stars
	 */
	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
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
		} else isFreeRoom = true;
		return isFreeRoom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public RoomModel clone() throws CloneNotSupportedException {
		return (RoomModel)super.clone(); 
	}
}
