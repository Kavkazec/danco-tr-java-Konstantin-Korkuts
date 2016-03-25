package com.danco.training.services.api;

import java.util.List;

import com.danco.training.entity.Room;

public interface IRoomService {
	public Room getByIdRoom(int id);
	public void addRoom(Room room);
	public void deleteRoom(Room room);
	public void updateRoom(Room room);
	public List<Room> sortByCoastFreeRoom();
	public List<Room> sortByCapacityFreeRoom();
	public List<Room> sortByStarsFreeRoom();
	public List<Room> sortByCoastRoom();
	public List<Room> sortByCapacityRoom();
	public List<Room> sortByStarsRoom();
	public List<Room> getRooms();
	public int numberOfFreeRooms();
	public void changeRoomStatus(Room room);
	public void changeRoomCoast(Room room);
	public void cloneRoom(Room room);
	public String showRoomDetails(Room room);
	public void exportRooms();
	public void importRooms();
	public void buildRoomsFromAnnot();
}
