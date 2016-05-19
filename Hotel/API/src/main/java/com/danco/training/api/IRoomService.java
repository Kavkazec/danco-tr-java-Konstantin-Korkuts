package com.danco.training.api;

import java.util.List;

import com.danco.training.entity.Room;

public interface IRoomService {
	public Room getByIdRoom(int id);
	public void addRoom(Room room);
	public void deleteRoom(Room room);
	public void updateRoom(Room room);
	public List<Room> sortRoomsBy(String status, String criterion);
	public List<Room> getRooms();
	public int numberOfFreeRooms();
	public void changeRoomStatus(Room room);
	public void changeRoomCoast(Room room);
	public void cloneRoom(Room room);
	public String showRoomDetails(Room room);
	public void exportRooms();
	public void importRooms();
}
