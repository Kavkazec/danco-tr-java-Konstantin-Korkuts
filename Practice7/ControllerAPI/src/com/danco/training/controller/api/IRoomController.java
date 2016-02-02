package com.danco.training.controller.api;

import java.util.Date;
import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;

public interface IRoomController {
	public void addRoom(RoomModel room);
	public void deleteRoom(int number);
	public void deleteGuestFromRoom(String name);
	public void deleteAllGuestsFromRoom(int number);
	public void changeRoomsCoast(int number, int coast);
	public void changeRoomsStatusRepair();
	public List<RoomModel> sortByCoastFreeRoom();
	public List<RoomModel> sortByCopasityFreeRoom();
	public List<RoomModel> sortByStarsFreeRoom();
	public List<RoomModel> sortByCoastRoom();
	public List<RoomModel> sortByCopasityRoom();
	public List<RoomModel> sortByStarsRoom();
	public int showNumberOfFreeRooms();
	public List<RoomModel> showChekOutDate(Date date);
	public String showRoomDetails(int number);
	public String showPricePerRoom(String name);
	public List<GuestModel> showLastThreeGuests(int number);
	public void addGuestInRoom(int number, String name);
	public List<RoomModel> printRoom();
	public void cloneRoom(int number);
	public void exportRooms();
	public void importRooms();
}
