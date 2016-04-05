package com.danco.training.controller;

import java.util.Date;
import java.util.List;

import com.danco.training.api.IGuestService;
import com.danco.training.api.IHotelController;
import com.danco.training.api.IRoomService;
import com.danco.training.api.IServiceService;
import com.danco.training.api.ISettlementService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public class HotelController implements IHotelController {
	private RoomController roomCon;
	private GuestController guestCon;
	private ServiceController serviceCon;
	private SettlementController setCon;
	private static HotelController instance;
	
	public static HotelController getInstance(){
		if(instance == null){
			instance = new HotelController();
		}
		return instance;
	}
	
	
	public RoomController getRoomCon() {
		if(roomCon == null){
			roomCon = new RoomController((IRoomService) DependencyInjection.getInstance().getClassInstance(IRoomService.class));
		}
		return roomCon;
	}
	
	public GuestController getGuestCon() {
		if(guestCon == null){
			guestCon = new GuestController((IGuestService) DependencyInjection.getInstance().getClassInstance(IGuestService.class));
		}
		return guestCon;
	}
	
	public ServiceController getServiceCon() {
		if(serviceCon == null){
			serviceCon = new ServiceController((IServiceService) DependencyInjection.getInstance().getClassInstance(IServiceService.class));
		}
		return serviceCon;
	}
	
	public SettlementController getSettlementCon() {
		if(setCon == null){
			setCon = new SettlementController((ISettlementService) DependencyInjection.getInstance().getClassInstance(ISettlementService.class));
		}
		return setCon;
	}

	public void addGuest(Guest guest) {
		getGuestCon().addGuest(guest);
	}

	public void deleteGuest(Guest guest) {
		getGuestCon().deleteGuest(guest);
	}

	public void updateGuest(Guest guest) {
		getGuestCon().updateGuest(guest);
	}

	public List<Guest> getGuests() {
		return getGuestCon().getGuests();
	}

	public int numberOfGuests() {
		return getGuestCon().numberOfGuests();
	}

	public void exportGuests() {
		getGuestCon().exportGuests();
	}

	public void importGuests() {
		getGuestCon().importGuests();
	}

	public void addRoom(Room room) {
		getRoomCon().addRoom(room);
	}

	public void deleteRoom(Room room) {
		getRoomCon().deleteRoom(room);
	}

	public void updateRoom(Room room) {
		getRoomCon().updateRoom(room);
	}

	public List<Room> getRooms() {
		return getRoomCon().getRooms();
	}

	public int numberOfFreeRooms() {
		return getRoomCon().numberOfFreeRooms();
	}

	public void changeRoomStatus(Room room) {
		getRoomCon().changeRoomStatus(room);
	}

	public void changeRoomCoast(Room room) {
		getRoomCon().changeRoomCoast(room);
	}

	public void cloneRoom(Room room) {
		getRoomCon().cloneRoom(room);
	}

	public String showRoomDetails(Room room) {
		return getRoomCon().showRoomDetails(room);
	}

	public void exportRooms() {
		getRoomCon().exportRooms();
	}

	public void importRooms() {
		getRoomCon().importRooms();
	}

	public void addService(Service service) {
		getServiceCon().addService(service);
	}

	public void deleteService(Service service) {
		getServiceCon().deleteService(service);
	}

	public void updateService(Service service) {
		getServiceCon().updateService(service);
	}

	public List<Service> getServices() {
		return getServiceCon().getServices();
	}

	public void changeServiceCoast(Service service) {
		getServiceCon().changeServiceCoast(service);
	}

	public void exportServices() {
		getServiceCon().exportServices();
	}

	public void importServices() {
		getServiceCon().importServices();
	}

	public List<Settlement> getAll() {
		return getSettlementCon().getAll();
	}

	public void add(Settlement model) {
		getSettlementCon().add(model);
	}

	public void delete(Settlement model) {
		getSettlementCon().delete(model);
	}

	public void update(Settlement model) {
		getSettlementCon().update(model);
	}

	public List<Room> releasedInTheFuture(Date date) {
		return getSettlementCon().releasedInTheFuture(date);
	}

	public List<Guest> showLastThreeGuest(Room room) {
		return getSettlementCon().showLastThreeGuest(room);
	}

	public int paiForRoom(Guest guest) {
		return getSettlementCon().paiForRoom(guest);
	}

	public Guest getByIdGuest(int id) {
		return getGuestCon().getByIdGuest(id);
	}

	public Room getByIdRoom(int id) {
		return getRoomCon().getByIdRoom(id);
	}

	public Service getByIdService(int id) {
		return getServiceCon().getByIdService(id);
	}

	public Settlement getByIdSettlement(int id) {
		return getSettlementCon().getByIdSettlement(id);
	}

	public void exportSettlements() {
		getSettlementCon().exportSettlements();
	}

	public void importSettlements() {
		getSettlementCon().importSettlements();
	}

	public List<Room> sortRoomsBy(String status, String criterion) {
		return getRoomCon().sortRoomsBy(status,criterion);
	}

	public List<String> servicesAndRoomsPriceSortedBy(String string) {
		return getSettlementCon().servicesAndRoomsPriceSortedBy(string);
	}

	public List<String> listGuestsAndRoomsSortedBy(String string) {
		return getSettlementCon().listGuestsAndRoomsSortedBy(string);
	}

	public List<String> listGuestServicesSortedBy(Guest guest, String string) {
		return getSettlementCon().listGuestServicesSortedBy(guest, string);
	}

	public void addServiceToGuest(Guest guest, Service service, Date date) {
		getSettlementCon().addServiceToGuest(guest, service, date);
	}
}
