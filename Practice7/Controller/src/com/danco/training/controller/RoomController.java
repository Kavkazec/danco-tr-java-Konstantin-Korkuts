package com.danco.training.controller;


import java.util.Date;

import com.danco.training.controller.api.IGuestController;
import com.danco.training.controller.api.IRoomController;
import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InRoom;
import com.danco.training.controller.utils.PrintGuest;
import com.danco.training.controller.utils.PrintRoom;

public class RoomController {
	
	private static final String PUSTOTA = "";
	private static final String DETAILS_ROOM = "number ; capacity ; stats ; coast ; free? ; on repair?";
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	private static final String LINE = "-------------------------------------------";

	private InReader inReader;
	private InRoom inRoom;
	private PrintRoom printRoom;
	private PrintGuest prinGuest;
	
	private IRoomController roomCon;
	private IGuestController guestCon;
	
	public RoomController(IRoomController roomCon,IGuestController guestCon){
		this.roomCon = roomCon;
		this.guestCon = guestCon;
	}
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
	
	public InRoom getInRoom() {
		if(inRoom == null){
			inRoom = new InRoom();
		}
		return inRoom;
	}
	
	public void addRoom(){
		this.roomCon.addRoom(getInRoom().inputRoom());
	}
	
	public void deleteRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		this.roomCon.deleteRoom(number);
	}
	
	public void deleteGuestFromRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < this.roomCon.printRoom().size(); i++){
			getPrinGuest().printGuests(this.roomCon.printRoom().get(i).getGuests());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		this.roomCon.deleteGuestFromRoom(name);
	}
	
	public void deleteAllGuestsFromRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		this.roomCon.deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		this.roomCon.changeRoomsCoast(number, coast);
	}
	
	public void changeRoomsStatusRepair(){
		this.roomCon.changeRoomsStatusRepair();
	}
	
	public void sortByCoastFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByCoastFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCopasityFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByCopasityFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByStarsFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByStarsFreeRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCoastRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByCoastRoom());
		getInReader().print(LINE);
	}
	
	public void sortByCopasityRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByCopasityRoom());
		getInReader().print(LINE);
	}
	
	public void sortByStarsRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.sortByStarsRoom());
		getInReader().print(LINE);
	}
	
	public void showNumberOfFreeRooms(){
		String str = this.roomCon.showNumberOfFreeRooms() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showChekOutDate(){
		getInReader().print("Input date:");
		Date dateOfArr = getInReader().readDate();
		getPrintRoom().printRooms(this.roomCon.showChekOutDate(dateOfArr));
	}
	
	public void showRoomDetails(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print(this.roomCon.showRoomDetails(number));
	}
	
	public void showPricePerRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < this.roomCon.printRoom().size(); i++){
			getPrinGuest().printGuests(this.roomCon.printRoom().get(i).getGuests());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getInReader().print(this.roomCon.showPricePerRoom(name));
	}
	
	public void showLastThreeGuests(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getPrinGuest().printGuests(this.roomCon.showLastThreeGuests(number));
	}
	
	public void addGuestInRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print(DETAILS_GUEST);
		getPrinGuest().printGuests(this.guestCon.printGuest());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		this.roomCon.addGuestInRoom(number, name);
	}
	
	public void printRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
	}
	
	public void cloneRoom(){
		getInReader().print(DETAILS_ROOM);
		getPrintRoom().printRooms(this.roomCon.printRoom());
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		this.roomCon.cloneRoom(number);
	}
	
	public void exportRooms(){
		this.roomCon.exportRooms();
	}
	
	public void importRooms(){
		this.roomCon.importRooms();
	}
}
