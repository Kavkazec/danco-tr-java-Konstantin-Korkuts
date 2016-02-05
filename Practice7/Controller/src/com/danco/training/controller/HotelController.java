package com.danco.training.controller;

import com.danco.training.controller.api.IGuestController;
import com.danco.training.controller.api.IRoomController;
import com.danco.training.controller.api.IServiceController;
import com.danco.training.di.DependencyInjection;

public class HotelController {
	private GuestController guestCon;
	private RoomController roomCon;
	private ServiceController serviceCon;
	
	private static HotelController instance;
	
	private HotelController(){
	}
	
	public static HotelController getInstance(){
		if(instance == null){
			instance = new HotelController();
		}
		return instance;
	}
	
	public RoomController getRoomCon() {
		if(roomCon == null){
			roomCon = new RoomController((IRoomController) DependencyInjection.getInstance().getClassInstance(IRoomController.class),
					(IGuestController) DependencyInjection.getInstance().getClassInstance(IGuestController.class));
		}
		return roomCon;
	}
	
	public GuestController getGuestCon() {
		if(guestCon == null){
			guestCon = new GuestController((IGuestController) DependencyInjection.getInstance().getClassInstance(IGuestController.class), 
					(IServiceController) DependencyInjection.getInstance().getClassInstance(IServiceController.class));
		}
		return guestCon;
	}
	
	public ServiceController getServiceCon() {
		if(serviceCon == null){
			serviceCon = new ServiceController((IServiceController) DependencyInjection.getInstance().getClassInstance(IServiceController.class));
		}
		return serviceCon;
	}
	
	public void addGuest(){
		getGuestCon().addGuest();
	}
	
	public void deletGuest(){
		getGuestCon().deletGuest();
	}
	
	public void sortByNameGuests(){
		getGuestCon().sortByNameGuests();
	}
	
	public void sortByDateGuests(){
		getGuestCon().sortByDateGuests();
	}
	
	public void showNumberOfGuests(){
		getGuestCon().showNumberOfGuests();
	}
	
	public void showGuestsServicesSortedByCoast(){
		getGuestCon().showGuestsServicesSortedByCoast();
	}
	
	public void showGuestsServicesSortedByDate(){
		getGuestCon().showGuestsServicesSortedByDate();
	}
	
	public void addServiceToGuest(){
		getGuestCon().addServiceToGuest();
	}
	
	public void printGuest(){
		getGuestCon().printGuest();
	}
	
	public void addRoom(){
		getRoomCon().addRoom();
	}
	
	public void deleteRoom(){
		getRoomCon().deleteRoom();
	}
	
	public void deleteGuestFromRoom(){
		getRoomCon().deleteGuestFromRoom();
	}
	
	public void deleteAllGuestsFromRoom(){
		getRoomCon().deleteAllGuestsFromRoom();
	}
	
	public void changeRoomsCoast(){
		getRoomCon().changeRoomsCoast();
	}
	
	public void changeRoomsStatusRepair(){
		getRoomCon().changeRoomsStatusRepair();
	}
	
	public void sortByCoastFreeRoom(){
		getRoomCon().sortByCoastFreeRoom();
	}
	
	public void sortByCopasityFreeRoom(){
		getRoomCon().sortByCopasityFreeRoom();
	}
	
	public void sortByStarsFreeRoom(){
		getRoomCon().sortByStarsFreeRoom();
	}
	
	public void sortByCoastRoom(){
		getRoomCon().sortByCoastRoom();
	}
	
	public void sortByCopasityRoom(){
		getRoomCon().sortByCopasityRoom();
	}
	
	public void sortByStarsRoom(){
		getRoomCon().sortByStarsRoom();
	}
	
	public void showNumberOfFreeRooms(){
		getRoomCon().showNumberOfFreeRooms();
	}
	
	public void showChekOutDate(){
		getRoomCon().showChekOutDate();
	}
	
	public void showRoomDetails(){
		getRoomCon().showRoomDetails();
	}
	
	public void showPricePerRoom(){
		getRoomCon().showPricePerRoom();
	}
	
	public void showLastThreeGuests(){
		getRoomCon().showLastThreeGuests();
	}
	
	public void addGuestInRoom(){
		getRoomCon().addGuestInRoom();
	}
	
	public void printRoom(){
		getRoomCon().printRoom();
	}
	
	public void addService(){
		getServiceCon().addService();
	}
	
	public void deleteService(){
		getServiceCon().deleteService();
	}
	
	public void changeServicesCoast(){
		getServiceCon().changeServicesCoast();
	}
	
	public void printService(){
		getServiceCon().printService();
	}
	
	public void cloneRoom(){
		getRoomCon().cloneRoom();
	}
	
	public void exportGuests(){
		getGuestCon().exportGuests();
	}
	
	public void exportRooms(){
		getRoomCon().exportRooms();
	}
	
	public void exportServices(){
		getServiceCon().exportServices();
	}
	
	public void importServices(){
		getServiceCon().importServices();
	}
	
	public void importRooms(){
		getRoomCon().importRooms();
	}
	
	public void importGuests(){
		getGuestCon().importGuests();
	}
}
