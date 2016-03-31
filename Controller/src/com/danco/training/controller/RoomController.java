package com.danco.training.controller;

import java.util.List;

import com.danco.training.api.IRoomService;
import com.danco.training.entity.Room;

public class RoomController {
	private IRoomService roomCon;
	
	public RoomController(IRoomService roomCon){
		this.roomCon = roomCon;
	}
	
	public Room getByIdRoom(int id) {
		return this.roomCon.getByIdRoom(id);
		
	}
	
	public void addRoom(Room room){
		this.roomCon.addRoom(room);
	}
	public void deleteRoom(Room room){
		this.roomCon.deleteRoom(room);
	}
	public void updateRoom(Room room){
		this.roomCon.updateRoom(room);
	}
	public List<Room> sortRoomsBy(String string){
		return this.roomCon.sortRoomsBy(string);
	}
	public List<Room> sortFreeRoomsBy(String string){
		return this.roomCon.sortFreeRoomsBy(string);
	}
	
	public List<Room> getRooms(){
		return this.roomCon.getRooms();
	}
	public int numberOfFreeRooms(){
		return this.roomCon.numberOfFreeRooms();
	}
	public void changeRoomStatus(Room room){
		this.roomCon.changeRoomStatus(room);
	}
	public void changeRoomCoast(Room room){
		this.roomCon.changeRoomCoast(room);
	}
	public void cloneRoom(Room room){
		this.roomCon.cloneRoom(room);
	}
	public String showRoomDetails(Room room){
		return this.roomCon.showRoomDetails(room);
	}
	public void exportRooms(){
		this.roomCon.exportRooms();
	}
	public void importRooms(){
		this.roomCon.importRooms();
	}
	public void buildRoomsFromAnnot(){
		this.roomCon.buildRoomsFromAnnot();
	}
}
