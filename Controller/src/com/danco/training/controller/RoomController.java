package com.danco.training.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.danco.training.controller.api.IRoomService;
import com.danco.training.entity.GuestModel;
import com.danco.training.entity.RoomModel;

public class RoomController {
	private IRoomService roomCon;
	
	public RoomController(IRoomService roomCon){
		this.roomCon = roomCon;
	}
	
	public void addRoom(RoomModel room){
		this.roomCon.addRoom(room);
	}
	
	public void deleteRoom(int number){
		this.roomCon.deleteRoom(number);
	}
	
	public void deleteGuestFromRoom(String name){
		this.roomCon.deleteGuestFromRoom(name);
	}
	
	public void deleteAllGuestsFromRoom(int number){
		this.roomCon.deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(int number, int coast){
		this.roomCon.changeRoomsCoast(number, coast);
	}
	
	public void changeRoomsStatusRepair(){
		this.roomCon.changeRoomsStatusRepair();
	}
	
	public List<RoomModel> sortByCoastFreeRoom(){
		return Collections.synchronizedList(this.roomCon.sortByCoastFreeRoom());
	}
	
	public List<RoomModel> sortByCopasityFreeRoom(){
		return Collections.synchronizedList(this.roomCon.sortByCopasityFreeRoom());
	}
	
	public List<RoomModel> sortByStarsFreeRoom(){
		return Collections.synchronizedList(this.roomCon.sortByStarsFreeRoom());
	}
	
	public List<RoomModel> sortByCoastRoom(){
		return Collections.synchronizedList(this.roomCon.sortByCoastRoom());
	}
	
	public List<RoomModel> sortByCopasityRoom(){
		return Collections.synchronizedList(this.roomCon.sortByCopasityRoom());
	}
	
	public List<RoomModel> sortByStarsRoom(){
		return Collections.synchronizedList(this.roomCon.sortByCopasityRoom());
	}
	
	public int showNumberOfFreeRooms(){
		return this.roomCon.showNumberOfFreeRooms();
	}
	
	public List<RoomModel> showChekOutDate(Date date){
		return Collections.synchronizedList(this.roomCon.showChekOutDate(date));
	}
	
	public String showRoomDetails(int number){
		return this.roomCon.showRoomDetails(number);
	}
	
	public String showPricePerRoom(String name){
		return this.roomCon.showPricePerRoom(name);
	}
	
	public List<GuestModel> showLastThreeGuests(int number){
		return Collections.synchronizedList(this.roomCon.showLastThreeGuests(number));
	}
	
	public synchronized void addGuestInRoom(int number, String name){
		this.roomCon.addGuestInRoom(number, name);
	}
	
	public List<RoomModel> printRoom(){
		return Collections.synchronizedList(this.roomCon.printRoom());
	}
	
	public void cloneRoom(int number){
		this.roomCon.cloneRoom(number);
	}
	
	public synchronized void exportRooms(){
		this.roomCon.exportRooms();
	}
	
	public synchronized void importRooms(){
		this.roomCon.importRooms();
	}
	public synchronized void buildRoomsFromAnnot(){
		this.roomCon.buildRoomsFromAnnot();
	}
}
