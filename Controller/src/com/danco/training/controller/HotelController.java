package com.danco.training.controller;

import java.util.Date;
import java.util.List;

import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.services.api.IGuestService;
import com.danco.training.services.api.IHotelController;
import com.danco.training.services.api.IRoomService;
import com.danco.training.services.api.IServiceService;
import com.danco.training.services.api.ISettlementService;

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

	@Override
	public void addGuest(Guest guest) {
		getGuestCon().addGuest(guest);
	}

	@Override
	public void deleteGuest(Guest guest) {
		getGuestCon().deleteGuest(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		getGuestCon().updateGuest(guest);
	}

	@Override
	public List<Guest> getGuests() {
		return getGuestCon().getGuests();
	}

	@Override
	public int numberOfGuests() {
		return getGuestCon().numberOfGuests();
	}

	@Override
	public void exportGuests() {
		getGuestCon().exportGuests();
	}

	@Override
	public void importGuests() {
		getGuestCon().importGuests();
	}

	@Override
	public void buildGuestsFromAnnot() {
		getGuestCon().buildGuestsFromAnnot();
	}

	@Override
	public void addRoom(Room room) {
		getRoomCon().addRoom(room);
	}

	@Override
	public void deleteRoom(Room room) {
		getRoomCon().deleteRoom(room);
	}

	@Override
	public void updateRoom(Room room) {
		getRoomCon().updateRoom(room);
	}

	@Override
	public List<Room> sortByCoastFreeRoom() {
		return getRoomCon().sortByCoastFreeRoom();
	}

	@Override
	public List<Room> sortByCapacityFreeRoom() {
		return getRoomCon().sortByCapacityFreeRoom();
	}

	@Override
	public List<Room> sortByStarsFreeRoom() {
		return getRoomCon().sortByStarsFreeRoom();
	}

	@Override
	public List<Room> sortByCoastRoom() {
		return getRoomCon().sortByCoastRoom();
	}

	@Override
	public List<Room> sortByCapacityRoom() {
		return getRoomCon().sortByCapacityRoom();
	}

	@Override
	public List<Room> sortByStarsRoom() {
		return getRoomCon().sortByStarsRoom();
	}

	@Override
	public List<Room> getRooms() {
		return getRoomCon().getRooms();
	}

	@Override
	public int numberOfFreeRooms() {
		return getRoomCon().numberOfFreeRooms();
	}

	@Override
	public void changeRoomStatus(Room room) {
		getRoomCon().changeRoomStatus(room);
	}

	@Override
	public void changeRoomCoast(Room room) {
		getRoomCon().changeRoomCoast(room);
	}

	@Override
	public void cloneRoom(Room room) {
		getRoomCon().cloneRoom(room);
	}

	@Override
	public String showRoomDetails(Room room) {
		return getRoomCon().showRoomDetails(room);
	}

	@Override
	public void exportRooms() {
		getRoomCon().exportRooms();
	}

	@Override
	public void importRooms() {
		getRoomCon().importRooms();
	}

	@Override
	public void buildRoomsFromAnnot() {
		getRoomCon().buildRoomsFromAnnot();
	}

	@Override
	public void addService(Service service) {
		getServiceCon().addService(service);
	}

	@Override
	public void deleteService(Service service) {
		getServiceCon().deleteService(service);
	}

	@Override
	public void updateService(Service service) {
		getServiceCon().updateService(service);
	}

	@Override
	public List<Service> getServices() {
		return getServiceCon().getServices();
	}

	@Override
	public void changeServiceCoast(Service service) {
		getServiceCon().changeServiceCoast(service);
	}

	@Override
	public void exportServices() {
		getServiceCon().exportServices();
	}

	@Override
	public void importServices() {
		getServiceCon().importServices();
	}

	@Override
	public void buildServicesFromAnnot() {
		getServiceCon().buildServicesFromAnnot();
	}

	@Override
	public List<Settlement> getAll() {
		return getSettlementCon().getAll();
	}

	@Override
	public void add(Settlement model) {
		getSettlementCon().add(model);
	}

	@Override
	public void delete(Settlement model) {
		getSettlementCon().delete(model);
	}

	@Override
	public void update(Settlement model) {
		getSettlementCon().update(model);
	}

	@Override
	public List<Room> releasedInTheFuture(Date date) {
		return getSettlementCon().releasedInTheFuture(date);
	}

	@Override
	public List<Guest> showLastThreeGuest(Room room) {
		return getSettlementCon().showLastThreeGuest(room);
	}

	@Override
	public int paiForRoom(Guest guest) {
		return getSettlementCon().paiForRoom(guest);
	}

	@Override
	public int servicesAndRoomsPriceSortedByCoast() {
		return getSettlementCon().servicesAndRoomsPriceSortedByCoast();
	}

	@Override
	public int servicesAndRoomsPriceSortedByType() {
		return getSettlementCon().servicesAndRoomsPriceSortedByType();
	}

	@Override
	public List<String> listGuestsAndRoomsSortedByName() {
		return getSettlementCon().listGuestsAndRoomsSortedByName();
	}

	@Override
	public List<String> listGuestsAndRoomsSortedByDate() {
		return getSettlementCon().listGuestsAndRoomsSortedByDate();
	}

	@Override
	public List<Service> listGuestServicesSortedByCoast(Guest guest) {
		return getSettlementCon().listGuestServicesSortedByCoast(guest);
	}

	@Override
	public List<Service> listGuestServicesSortedByDate(Guest guest) {
		return getSettlementCon().listGuestServicesSortedByDate(guest);
	}

	@Override
	public Guest getByIdGuest(int id) {
		return getGuestCon().getByIdGuest(id);
	}

	@Override
	public Room getByIdRoom(int id) {
		return getRoomCon().getByIdRoom(id);
	}

	@Override
	public Service getByIdService(int id) {
		return getServiceCon().getByIdService(id);
	}

	@Override
	public Settlement getByIdSettlement(int id) {
		return getSettlementCon().getByIdSettlement(id);
	}
}
