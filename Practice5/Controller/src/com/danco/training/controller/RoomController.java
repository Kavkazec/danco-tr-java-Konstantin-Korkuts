package com.danco.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InRoom;
import com.danco.training.service.HotelService;

public class RoomController {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final String PUSTOTA = "";
	private static final String DASH = "-";
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
	}
	
	public void deleteRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteRoom(number);
	}
	
	public void deleteGuestFromRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			for(int j = 0; j < getService().getRooms().get(i).getGuests().size(); j++)
			getInReader().print(getService().getRooms().get(i).getGuests().get(j).toString());
		}
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().deleteGuestFromRoom(name);
	}
	
	public void deleteAllGuestsFromRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
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
		for(int i = 0; i < getService().sortByCoastFreeRoom().size(); i++){
			getInReader().print(getService().sortByCoastFreeRoom().get(i).toString());
		}
	}
	
	public void sortByCopasityFreeRoom(){
		for(int i = 0; i < getService().sortByCopasityFreeRoom().size(); i++){
			getInReader().print(getService().sortByCopasityFreeRoom().get(i).toString());
		}
	}
	
	public void sortByStarsFreeRoom(){
		for(int i = 0; i < getService().sortByStarsFreeRoom().size(); i++){
			getInReader().print(getService().sortByStarsFreeRoom().get(i).toString());
		}
	}
	
	public void sortByCoastRoom(){
		for(int i = 0; i < getService().sortByCoastRoom().size(); i++){
			getInReader().print(getService().sortByCoastRoom().get(i).toString());
		}
	}
	
	public void sortByCopasityRoom(){
		for(int i = 0; i < getService().sortByCopasityRoom().size(); i++){
			getInReader().print(getService().sortByCopasityRoom().get(i).toString());
		}
	}
	
	public void sortByStarsRoom(){
		for(int i = 0; i < getService().sortByStarsRoom().size(); i++){
			getInReader().print(getService().sortByStarsRoom().get(i).toString());
		}
	}
	
	public void showNumberOfFreeRooms(){
		String str = getService().showNumberOfGuests() + PUSTOTA;
		getInReader().print(str);
	}
	
	public void showChekOutDate() throws ParseException{
		getInReader().print("Day:");
		int dayOfArr = getInReader().readInt();
		getInReader().print("Month:");
		int monthOfArr = getInReader().readInt();
		getInReader().print("Year:");
		int yearOfArr = getInReader().readInt();
		String dateOfArr = dayOfArr + DASH + monthOfArr + DASH + yearOfArr;
		getService().showChekOutDate(sdf.parse(dateOfArr));
	}
	
	public void showRoomDetails(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().showRoomDetails(number);
	}
	
	public void showPricePerRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			for(int j = 0; j < getService().getRooms().get(i).getGuests().size(); j++)
			getInReader().print(getService().getRooms().get(i).getGuests().get(j).toString());
		}
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().showPricePerRoom(name);
	}
	
	public void showLastThreeGuests(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getService().showLastThreeGuests(number);
	}
	
	public void addGuestInRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
		
		for(int i = 0; i < getService().getGuests().size(); i++){
			getInReader().print(getService().getGuests().get(i).toString());
		}
		getInReader().print("Room's number:");
		int number = getInReader().readInt();
		getInReader().print("Guest's name:");
		String name = getInReader().readStrin();
		getService().addGuestInRoom(number, name);
	}
	
	public void printRoom(){
		for(int i = 0; i < getService().getRooms().size(); i++){
			getInReader().print(getService().getRooms().get(i).toString());
		}
	}
}
