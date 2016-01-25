package com.danco.training.controller;

import org.apache.log4j.Logger;

import com.danco.training.controller.utils.InReader;
import com.danco.training.service.HotelService;

public class HotelController {
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	private static HotelService service = HotelService.getInstance();
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
	
	
	public GuestController getGuestCon() {
		if(guestCon == null){
			guestCon = new GuestController();
		}
		return guestCon;
	}
	public RoomController getRoomCon() {
		if(roomCon == null){
			roomCon = new RoomController();
		}
		return roomCon;
	}
	public ServiceController getServiceCon() {
		if(serviceCon == null){
			serviceCon = new ServiceController();
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
		try{
		getGuestCon().printGuest();
		} catch(Exception e){
			LOGGER.error("INCORRECT_DATE_INPUT");
		}
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
	
	public void writeInFile(){
		service.writeInFile();
	}
	
	public void readFromFile(){
		service.readFromFile();
	}
}
