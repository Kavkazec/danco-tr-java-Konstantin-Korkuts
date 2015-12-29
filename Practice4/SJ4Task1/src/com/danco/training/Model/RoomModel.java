package com.danco.training.Model;

import java.util.ArrayList;

public class RoomModel{
	private int number;
	private int capacity;
	private int numberOfStars;
	private int coast;
	private boolean status = false;
	private ArrayList<GuestModel> guests = new ArrayList<GuestModel>();
	public RoomModel(int number, int capacity, int numberOfStars, int coast) {
		this.number = number;
		this.capacity = capacity;
		this.numberOfStars = numberOfStars;
		this.coast = coast;
		if(guests.size() < capacity){
			status = false;
		} else status = true;
		
	}
	public ArrayList<GuestModel> getGuests() {
		return guests;
	}
	public void setGuests(ArrayList<GuestModel> guests) {
		this.guests = guests;
	}
	public int getNumber() {
		return number;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getNumberOfStars() {
		return numberOfStars;
	}
	public void setCoast(int coast){
		this.coast = coast;
	}
	public int getCoast() {
		return coast;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(number));
		sb.append(";");
		sb.append(Integer.toString(capacity));
		sb.append(";");
		sb.append(Integer.toString(numberOfStars));
		sb.append(";");
		sb.append(Integer.toString(coast));
		sb.append(";");
		sb.append(Boolean.toString(status));
		sb.append(";");
		return sb.toString();
	}
}
