package com.danco.training.controller;

import java.util.List;

import com.danco.training.api.IGuestService;
import com.danco.training.entity.Guest;


public class GuestController {
	private IGuestService guestCon;
	
	public GuestController(IGuestService guestCon){
		this.guestCon = guestCon;
	}
	
	public Guest getByIdGuest(int id) {
		return this.guestCon.getByIdGuest(id);
	}
	
	public void addGuest(Guest guest){
		this.guestCon.addGuest(guest);
	}
	public void deleteGuest(Guest guest){
		this.guestCon.deleteGuest(guest);
	}
	public void updateGuest(Guest guest){
		this.guestCon.updateGuest(guest);
	}
	public List<Guest> getGuests(){
		return this.guestCon.getGuests();
	}
	public int numberOfGuests(){
		return this.guestCon.numberOfGuests();
	}
	public void exportGuests(){
		this.guestCon.exportGuests();
	}
	public void importGuests(){
		this.guestCon.importGuests();
	}
}