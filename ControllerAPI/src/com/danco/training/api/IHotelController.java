package com.danco.training.api;

import java.util.Date;
import java.util.List;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public interface IHotelController {
	public Guest getByIdGuest(int id);
	public Room getByIdRoom(int id);
	public Service getByIdService(int id);
	public Settlement getByIdSettlement(int id);
	public void addGuest(Guest guest);
	public void deleteGuest(Guest guest);
	public void updateGuest(Guest guest);
	public List<Guest> getGuests();
	public int numberOfGuests();
	public void exportGuests();
	public void importGuests();
	public void buildGuestsFromAnnot();
	public void addRoom(Room room);
	public void deleteRoom(Room room);
	public void updateRoom(Room room);
	public List<Room> sortRoomsBy(String string);
	public List<Room> sortFreeRoomsBy(String string);
	public List<Room> getRooms();
	public int numberOfFreeRooms();
	public void changeRoomStatus(Room room);
	public void changeRoomCoast(Room room);
	public void cloneRoom(Room room);
	public String showRoomDetails(Room room);
	public void exportRooms();
	public void importRooms();
	public void buildRoomsFromAnnot();
	public void addService(Service service);
	public void deleteService(Service service);
	public void updateService(Service service);
	public List<Service> getServices();
	public void changeServiceCoast(Service service);
	public void exportServices();
	public void importServices();
	public void buildServicesFromAnnot();
	public List<Settlement> getAll();
	public void add(Settlement model);
	public void addServiceToGuest(Guest guest, Service service, Date date);
	public void delete(Settlement model);
	public void update(Settlement model);
	public List<Room> releasedInTheFuture(Date date);
	public List<Guest> showLastThreeGuest(Room room);
	public int paiForRoom(Guest guest);
	public List<String> servicesAndRoomsPriceSortedBy(String string);
	public List<String> listGuestsAndRoomsSortedBy(String string);
	public List<String> listGuestServicesSortedBy(Guest guest , String string);
	public void exportSettlements();
	public void importSettlements();
}
