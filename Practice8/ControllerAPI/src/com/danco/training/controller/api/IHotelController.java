package com.danco.training.controller.api;

import java.util.Date;
import java.util.List;

import com.danco.training.entity.GuestModel;
import com.danco.training.entity.RoomModel;
import com.danco.training.entity.ServiceModel;

public interface IHotelController {
	public void addGuest(GuestModel guest);
	public void deleteGuest(String name);
	public List<GuestModel> sortByNameGuests();
	public List<GuestModel> sortByDateGuests();
	public int showNumberOfGuests();
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name);
	public List<ServiceModel> showGuestsServicesSortedByDate(String name);
	public void addServiceToGuest(String nameGuest, String nameService);
	public List<GuestModel> printGuest();
	public void exportGuests();
	public void importGuests();
	public void buildGuestsFromAnnot();
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
	public void buildRoomsFromAnnot();
	public void addService(ServiceModel service);
	public void deleteService(String name);
	public void changeServicesCoast(String name, int coast);
	public List<ServiceModel> printService();
	public void exportServices();
	public void importServices();
	public void buildServicesFromAnnot();
}
