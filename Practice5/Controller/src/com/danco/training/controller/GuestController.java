package com.danco.training.controller;

import java.text.ParseException;

import com.danco.training.controller.utils.InGuest;
import com.danco.training.controller.utils.InReader;
import com.danco.training.service.HotelService;

public class GuestController {
	private static final String PUSTOTA = "";
	private HotelService service;
	
	private InGuest inGuest;
	private InReader inReader;

	public InReader getInReader() {
		if(inReader == null){
			inReader = new InReader();
		}
		return inReader;
	}

	public HotelService getService() {
		if(service == null){
			service = HotelService.getInstance();
		}
		return service;
	}
	
	public InGuest getInGuest(){
		if(inGuest == null){
			inGuest = new InGuest();
		}
		return inGuest;
	}
	
	public void addGuest(){
			getService().addGuest(inGuest.inputGuest());
	}
	
	public void deletGuest(){
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().deleteGuest(name);
	}
	
	public void sortByNameGuests(){
		for(int i = 0; i < getService().sortByNameGuests().size(); i++){
			getInReader().print(getService().sortByNameGuests().get(i).toString());
		}
	}
	
	public void sortByDateGuests(){
		for(int i = 0; i < getService().sortByDateGuests().size(); i++){
			getInReader().print(getService().sortByDateGuests().get(i).toString());
		}
	}
	
	public void showNumberOfGuests(){
		String str = getService().showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showGuestsServicesSortedByCoast(){
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().showGuestsServicesSortedByCoast(name);
	}
	
	public void showGuestsServicesSortedByDate(){
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().showGuestsServicesSortedByDate(name);
	}
	
	public void addServiceToGuest(){
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		for(int i = 0; i < getService().getServices().size(); i++){
			getInReader().print(getService().getServices().get(i).toString());
		}
		getInReader().print("Guest's name:");
		String guest = getInReader().readStrin();
		getInReader().print("Service name:");
		String service = getInReader().readStrin();
		getService().addServiceToGuest(guest, service);
		
	}
	
	public void printGuest(){
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
	}
}
