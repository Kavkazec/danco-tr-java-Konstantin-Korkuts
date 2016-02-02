package com.danco.training.controller;

import com.danco.training.controller.api.IGuestController;
import com.danco.training.controller.api.IServiceController;
import com.danco.training.controller.utils.InGuest;
import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.PrintGuest;
import com.danco.training.controller.utils.PrintService;

public class GuestController {
	private static final String PUSTOTA = "";
	private IGuestController guestCon;
	private IServiceController serviceCon;
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String LINE = "-------------------------------------------";
	private PrintGuest prinGuest;
	private InGuest inGuest;
	private InReader inReader;
	private PrintService printService;
	
	public GuestController(IGuestController guestCon, IServiceController serviceCon){
		this.guestCon = guestCon;
		this.serviceCon = serviceCon;
	}
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
	
	public InGuest getInGuest(){
		if(inGuest == null){
			inGuest = new InGuest();
		}
		return inGuest;
	}
	
	public void addGuest(){
		this.guestCon.addGuest(getInGuest().inputGuest());
	}
	
	public void deletGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		this.guestCon.deleteGuest(name);
	}
	
	public void sortByNameGuests(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.sortByNameGuests());
		getInReader().print(LINE);
	}
	
	public void sortByDateGuests(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.sortByDateGuests());
		getInReader().print(LINE);
	}
	
	public void showNumberOfGuests(){
		String str = this.guestCon.showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showGuestsServicesSortedByCoast(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		if(!this.guestCon.showGuestsServicesSortedByCoast(name).isEmpty()){
			getPrintService().printServices(this.guestCon.showGuestsServicesSortedByCoast(name));
		} else {
			getInReader().print("There are no services!");
		}
	}
	
	public void showGuestsServicesSortedByDate(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		if(!this.guestCon.showGuestsServicesSortedByDate(name).isEmpty()){
			getPrintService().printServices(this.guestCon.showGuestsServicesSortedByDate(name));
		} else {
			getInReader().print("There are no services!");
		}
	}
	
	public void addServiceToGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(this.serviceCon.printService());
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String guest = getInReader().readStrin();
		getInReader().print("Service name:");
		String service = getInReader().readStrin();
		this.guestCon.addServiceToGuest(guest, service);
		
	}
	
	public void printGuest(){
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
	}
	
	public void exportGuests(){
		this.guestCon.exportGuests();
	}
	
	public void importGuests(){
		this.guestCon.importGuests();
	}
}
