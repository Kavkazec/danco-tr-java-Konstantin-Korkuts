package com.danco.training.controller;


import java.util.Date;

import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InRoom;
import com.danco.training.controller.utils.PrintGuest;
import com.danco.training.controller.utils.PrintRoom;
import com.danco.training.service.HotelService;

public class RoomController {
	
	private static final String PUSTOTA = "";
	private static final String DETAILS_ROOM = "number ; capacity ; stats ; coast ; free? ; on repair?";
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	private static final String LINE = "-------------------------------------------";

	private HotelService service;
	private InReader inReader;
	private InRoom inRoom;
	private PrintRoom printRoom;
	private PrintGuest prinGuest;
	
	public PrintRoom getPrintRoom() {
		if(printRoom == null){
			printRoom = new PrintRoom();
		}
		return printRoom;
	}

	public PrintGuest getPrinGuest() {
		if(prinGuest == null){
			prinGuest = new PrintGuest();
		}
		return prinGuest;
	}

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
	
	public InRoom getInRoom() {
		if(inRoom == null){
			inRoom = new InRoom();
		}
		return inRoom;
	}
	
	public void addRoom(){
		getService().addRoom(getInRoom().inputRoom());
	}
	
	public void deleteRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteRoom(number);
	}
	
	public void deleteGuestFromRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getPrinGuest().printGuests(getService().getRooms().get(i).getGuests());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().deleteGuestFromRoom(name);
	}
	
	public void deleteAllGuestsFromRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		getService().changeRoomsCoast(number, coast);
	}
	
	public void changeRoomsStatusRepair(){
		getService().changeRoomsStatusRepair();
	}
	
	public void sortByCoastFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByCoastFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCopasityFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByCopasityFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByStarsFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByStarsFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCoastRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByCoastRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCopasityRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByCopasityRoom());
		getInReader().print(LINE);
	}
	
	public void sortByStarsRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().sortByStarsRoom());
		getInReader().print(LINE);
	}
	
	public void showNumberOfFreeRooms(){
		String str = getService().showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showChekOutDate(){
		getInReader().print("Input date:");
		Date dateOfArr = getInReader().readDate();
		getPrintRoom().printRooms(getService().showChekOutDate(dateOfArr));
	}
	
	public void showRoomDetails(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print(getService().showRoomDetails(number));
	}
	
	public void showPricePerRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getPrinGuest().printGuests(getService().getRooms().get(i).getGuests());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getInReader().print(getService().showPricePerRoom(name));
	}
	
	public void showLastThreeGuests(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getPrinGuest().printGuests(getService().showLastThreeGuests(number));
	}
	
	public void addGuestInRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(getService().getGuests());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().addGuestInRoom(number, name);
	}
	
	public void printRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
	}
	
	public void cloneRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(getService().getRooms());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().cloneRoom(number);
	}
	
	public void exportRooms(){
		getService().exportRooms();
	}
	
	public void importRooms(){
		getService().importRooms();
	}
}
