package com.danco.training.controller;

import com.danco.training.controller.api.IGuestService;
import com.danco.training.controller.api.IHotelController;
import com.danco.training.controller.api.IRoomService;
import com.danco.training.controller.api.IServiceService;
import com.danco.training.di.DependencyInjection;

public class HotelController implements IHotelController {
	private RoomController roomCon;
	private GuestController guestCon;
	private ServiceController serviceCon;
	
	private static HotelController instance;
	
	public static HotelController getInstance(){
		if(instance == null){
			instance = new HotelController();
		}
		return instance;
	}
	
	public RoomController getRoomCon() {
		if(roomCon == null){
			roomCon = new RoomController((IRoomService) DependencyInjection.getInstance().getClassInstance(IRoomService.class),
					(IGuestService) DependencyInjection.getInstance().getClassInstance(IGuestService.class));
		}
		return roomCon;
	}
	
	public GuestController getGuestCon() {
		if(guestCon == null){
			guestCon = new GuestController((IGuestService) DependencyInjection.getInstance().getClassInstance(IGuestService.class), 
					(IServiceService) DependencyInjection.getInstance().getClassInstance(IServiceService.class));
		}
		return guestCon;
	}
	
	public ServiceController getServiceCon() {
		if(serviceCon == null){
			serviceCon = new ServiceController((IServiceService) DependencyInjection.getInstance().getClassInstance(IServiceService.class));
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
	
	public void buildServicesFromAnnot(){
		getServiceCon().buildServicesFromAnnot();
	}
	public void buildGuestsFromAnnot(){
		getGuestCon().buildGuestsFromAnnot();
	}
	public void buildRoomsFromAnnot(){
		getRoomCon().buildRoomsFromAnnot();
	}
}
