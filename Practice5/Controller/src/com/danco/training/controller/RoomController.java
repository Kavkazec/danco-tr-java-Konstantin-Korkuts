package com.danco.training.controller;


import java.util.Date;

import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InRoom;
import com.danco.training.service.HotelService;

public class RoomController {
	
	private static final String PUSTOTA = "";
	private static final String DETAILS_ROOM = "number ; capacity ; stats ; coast ; free? ;";
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	private static final String LINE = "-------------------------------------------";
	private static final String LINE_AFTER_ACTION = "#############################################";

	private HotelService service;
	private InReader inReader;
	private InRoom inRoom;
	
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
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void deleteRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteRoom(number);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void deleteGuestFromRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < getService().getRooms().size(); i++){
			for(int j = 0; j < getService().getRooms().get(i).getGuests().size(); j++)
			getInReader().print(getService().getRooms().get(i).getGuests().get(j).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().deleteGuestFromRoom(name);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void deleteAllGuestsFromRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteAllGuestsFromRoom(number);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void changeRoomsCoast(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		getService().changeRoomsCoast(number, coast);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void changeRoomsStatusRepair(){
		getService().changeRoomsStatusRepair();
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByCoastFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByCoastFreeRoom().size(); i++){
			getInReader().print(getService().sortByCoastFreeRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByCopasityFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByCopasityFreeRoom().size(); i++){
			getInReader().print(getService().sortByCopasityFreeRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByStarsFreeRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByStarsFreeRoom().size(); i++){
			getInReader().print(getService().sortByStarsFreeRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByCoastRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByCoastRoom().size(); i++){
			getInReader().print(getService().sortByCoastRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByCopasityRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByCopasityRoom().size(); i++){
			getInReader().print(getService().sortByCopasityRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void sortByStarsRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().sortByStarsRoom().size(); i++){
			getInReader().print(getService().sortByStarsRoom().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showNumberOfFreeRooms(){
		String str = getService().showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showChekOutDate(){
		getInReader().print("Input date:");
		Date dateOfArr = getInReader().readDate();
		for(int i = 0; i < getService().showChekOutDate(dateOfArr).size(); i++){
			getInReader().print(getService().showChekOutDate(dateOfArr).get(i).toString());
		}
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showRoomDetails(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print(getService().showRoomDetails(number));
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showPricePerRoom(){
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < getService().getRooms().size(); i++){
			for(int j = 0; j < getService().getRooms().get(i).getGuests().size(); j++)
			getInReader().print(getService().getRooms().get(i).getGuests().get(j).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getInReader().print(getService().showPricePerRoom(name));
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showLastThreeGuests(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print(getService().showLastThreeGuests(number));
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void addGuestInRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(DETAILS_GUEST);
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().addGuestInRoom(number, name);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void printRoom(){
		getInReader().print(DETAILS_ROOM);
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void writeRooms(){ 
		getService().writeRooms();
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showRoomsFromFile(){
		getInReader().print(DETAILS_ROOM);
		getInReader().print(getService().showRoomsFromFile());
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
}