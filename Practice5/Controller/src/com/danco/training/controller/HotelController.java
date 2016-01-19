package com.danco.training.controller;

import java.util.Date;
import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.service.HotelService;

public class HotelController {
	private static HotelService hotelServ = HotelService.getInstance();
	
	private static HotelController instance = null;
	
	private HotelController(){
		
	}
	
	public static HotelController getInstance(){
		if(instance == null){
			instance = new HotelController();
		}
		return instance;
	}
	
	public HotelService getHotelServ(){
		return hotelServ;
	}
	
	
	
	public void addGuest(GuestModel guest) {
		getHotelServ().addGuest(guest);
	}
	
	public void deleteGuest(GuestModel guest){
		getHotelServ().deleteGuest(guest);
	}
	
	public void updateGuest(GuestModel guest, String dateOfAdd, String dateOfEvi ){
		getHotelServ().updateGuest(guest, dateOfAdd, dateOfEvi);
	}
	
	public List<GuestModel> sortByNameGuests(){
		return getHotelServ().sortByNameGuests();
	}
	
	public List<GuestModel> sortByDateGuests(){
		return getHotelServ().sortByDateGuests();
	}
	
	public int showNumberOfGuests(){
		return getHotelServ().showNumberOfGuests();
	}
	
	public List<ServiceModel> showGuestsServicesSortedByCoast(GuestModel guest){
		return getHotelServ().showGuestsServicesSortedByCoast(guest);
	}
	
	public List<ServiceModel> showGuestsServicesSortedByDate(GuestModel guest){
		return getHotelServ().showGuestsServicesSortedByDate(guest);
	}
	
	public void addService(ServiceModel service){
		getHotelServ().addService(service);
	}
	
	public void deleteService(ServiceModel service){
		getHotelServ().deleteService(service);
	}
	
	public void changeServicesCoast(String name, int coast){
		getHotelServ().changeServicesCoast(name, coast);
	}
	
	public void addRoom(RoomModel room){
		getHotelServ().addRoom(room);
	}
	
	public void deleteRoom(RoomModel room){
		getHotelServ().deleteRoom(room);
	}
	
	public void updateRoom(RoomModel room, int numberOfStars){
		getHotelServ().updateNumber(room, numberOfStars);
	}
	
	public void deleteGuestFromRoom(RoomModel room, GuestModel guest){
		getHotelServ().deleteGuestFromRoom(room, guest);
	}
	
	public void deleteAllGuestsFromRoom(RoomModel room){
		getHotelServ().deleteAllGuestsFromRoom(room);
	}
	
	public void changeRoomsCoast(RoomModel room, int coast){
		getHotelServ().changeRoomsCoast(room, coast);
	}
	
	public void changeRoomsStatusRepair(){
		getHotelServ().changeRoomsStatusRepair();
	}
	
	public List<RoomModel> sortByCoastFreeRoom(){
		return getHotelServ().sortByCoastFreeRoom();
	}
	
	public List<RoomModel> sortByCopasityFreeRoom(){
		return getHotelServ().sortByCopasityFreeRoom();
	}
	
	public List<RoomModel> sortByStarsFreeRoom(){
		return getHotelServ().sortByStarsFreeRoom();
	}
	
	public List<RoomModel> sortByCoastRoom(){
		return getHotelServ().sortByCoastRoom();
	}
	
	public List<RoomModel> sortByCopasityRoom(){
		return getHotelServ().sortByCopasityRoom();
	}
	
	public List<RoomModel> sortByStarsRoom(){
		return getHotelServ().sortByStarsRoom();
	}
	
	public int showNumberOfFreeRooms(){
		return getHotelServ().showNumberOfFreeRooms();
	}
	
	public List<RoomModel> showChekOutDate(Date date){
		return getHotelServ().showChekOutDate(date);
	}
	
	public String showPricePerRoom(GuestModel guest){
		return getHotelServ().showPricePerRoom(guest);
	}
	
	public String showLastThreeGuests(RoomModel room){
		return getHotelServ().showLastThreeGuests(room);
	}
	
	public void addServiceToGuest( GuestModel guest,ServiceModel service){
		getHotelServ().addServiceToGuest(guest, service);
	}
	
	public void addGuestInRoom( RoomModel room , GuestModel guest){
		getHotelServ().addGuestInRoom(room, guest);
	}
	
	public void writeGuests(){
		getHotelServ().writeGuests();
	}
	
	public void writeRooms(){
		getHotelServ().writeRooms();
	}
	
	public void writeServices(){
		getHotelServ().writeServices();
	}
	
	public String showGuestsFromFile(){
		return getHotelServ().showGuestsFromFile();
	}
	
	public String showRoomsFromFile(){
		return getHotelServ().showRoomsFromFile();
	}
	
	public String showServicesFromFile(){
		return getHotelServ().showServicesFromFile();
	}
	
	public void show(){
		hotelServ.hah();
	}

	public void showW() {
		System.out.println("sgasdg");	
	}
	
	
}
