package com.danco.training.controller;

import com.danco.training.controller.utils.InGuest;
import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.PrintGuest;
import com.danco.training.controller.utils.PrintService;
import com.danco.training.service.HotelService;

public class GuestController {
	private static final String PUSTOTA = "";
	private HotelService service;
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String LINE = "-------------------------------------------";
	private PrintGuest prinGuest;
	private InGuest inGuest;
	private InReader inReader;
	private PrintService printService;

	public PrintService getPrintService() {
		if(printService == null){
			printService = new PrintService();
		}
		return printService;
	}
	public InReader getInReader() {
		if(inReader == null){
			inReader = new InReader();
		}
		return inReader;
	}
	public PrintGuest getPrinGuest() {
		if(prinGuest == null){
			prinGuest = new PrintGuest();
		}
		return prinGuest;
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
			getService().addGuest(getInGuest().inputGuest());
	}
	
	public void deletGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().deleteGuest(name);
	}
	
	public void sortByNameGuests(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().sortByNameGuests());
		getInReader().print(LINE);
	}
	
	public void sortByDateGuests(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().sortByDateGuests());
		getInReader().print(LINE);
	}
	
	public void showNumberOfGuests(){
		String str = getService().showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showGuestsServicesSortedByCoast(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		if(!getService().showGuestsServicesSortedByCoast(name).isEmpty()){
			getPrintService().printServices(getService().showGuestsServicesSortedByCoast(name));
		} else {
			getInReader().print("There are no services!");
		}
	}
	
	public void showGuestsServicesSortedByDate(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		if(!getService().showGuestsServicesSortedByDate(name).isEmpty()){
			getPrintService().printServices(getService().showGuestsServicesSortedByDate(name));
		} else {
			getInReader().print("There are no services!");
		}
	}
	
	public void addServiceToGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(getService().getServices());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String guest = getInReader().readStrin();
		getInReader().print("Service name:");
		String service = getInReader().readStrin();
		getService().addServiceToGuest(guest, service);
		
	}
	
	public void printGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
	}
	
	public void exportGuests(){
		getService().exportGuests();
	}
	
	public void importGuests(){
		getService().importGuests();
	}
}
