package com.danco.training.controller;

import java.util.Collections;
import java.util.List;

import com.danco.training.controller.api.IGuestService;
import com.danco.training.entity.GuestModel;
import com.danco.training.entity.ServiceModel;


public class GuestController {
	private IGuestService guestCon;
	
	public GuestController(IGuestService guestCon){
		this.guestCon = guestCon;
	}
	
	public void addGuest(GuestModel guest){
			this.guestCon.addGuest(guest);
	}
	
	public void deletGuest(String name){
		this.guestCon.deleteGuest(name);
	}
	
	public List<GuestModel> sortByNameGuests(){
		return Collections.synchronizedList(this.guestCon.sortByNameGuests());
	}
	
	public List<GuestModel> sortByDateGuests(){
		return Collections.synchronizedList(this.guestCon.sortByDateGuests());
	}
	
	public int showNumberOfGuests(){
		return this.guestCon.showNumberOfGuests();
	}
	
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name){
		return Collections.synchronizedList(this.guestCon.showGuestsServicesSortedByCoast(name));
	}
	
	public List<ServiceModel> showGuestsServicesSortedByDate(String name){
		return Collections.synchronizedList(this.guestCon.showGuestsServicesSortedByDate(name));
	}
	
	public synchronized void addServiceToGuest(String nameGuest, String nameService){
		this.guestCon.addServiceToGuest(nameGuest, nameService);
	}
	
	public List<GuestModel> printGuest(){
		return Collections.synchronizedList(this.guestCon.printGuest());
	}
	
	public synchronized void exportGuests(){
		this.guestCon.exportGuests();
	}
	
	public synchronized void importGuests(){
		this.guestCon.importGuests();
	}
	public synchronized void buildGuestsFromAnnot(){
		this.guestCon.buildGuestsFromAnnot();
	}
}
