package com.danco.training.service;

import java.util.Date;
import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelService.
 */
public class HotelService {
	
	/** The guest serv. */
	private GuestService guestServ = new GuestService();
	
	/** The room serv. */
	private RoomService roomServ = new RoomService();
	
	/** The service serv. */
	private ServiceService serviceServ = new ServiceService();
	
	/**
	 * Instantiates a new hotel service.
	 */
	
	private static HotelService instance = null;
	
	private HotelService(){
		
	}
	
	
	public static HotelService getInstance(){
		if(instance == null){
			instance = new HotelService();
		}
		return instance;
	}
	
	/**
	 * Gets the guest serv.
	 *
	 * @return the guest serv
	 */
	public GuestService getGuestServ() {
		return guestServ;
	}

	/**
	 * Gets the room serv.
	 *
	 * @return the room serv
	 */
	public RoomService getRoomServ() {
		return roomServ;
	}

	/**
	 * Gets the service serv.
	 *
	 * @return the service serv
	 */
	public ServiceService getServiceServ() {
		return serviceServ;
	}
	
	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
		return getGuestServ().getGuests();
	}
	
	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	public void addGuest(GuestModel guest) {
		getGuestServ().addGuest(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(String str){
		getGuestServ().deleteGuest(str);
	}
	
	/**
	 * Sort by name guests.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByNameGuests(){
		return getGuestServ().sortByName();
	}
	
	/**
	 * Sort by date guests.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByDateGuests(){
		return getGuestServ().sortByDate();
	}
	
	/**
	 * Show number of guests.
	 *
	 * @return the int
	 */
	public int showNumberOfGuests(){
		return getGuestServ().showAllGuests();
	}
	
	/**
	 * Show guests services sorted by coast.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name){
		return getGuestServ().showListOfServicesSortedByCoast(name);
	}
	
	/**
	 * Show guests services sorted by date.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByDate(String name){
		return getGuestServ().showListOfServicesSortedByDate(name);
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<ServiceModel> getServices(){
		return getServiceServ().getServices();
	}
	
	/**
	 * Adds the service.
	 *
	 * @param service the service
	 */
	public void addService(ServiceModel service){
		getServiceServ().addService(service);
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(String name){
		getServiceServ().deleteService(name);
	}
	
	/**
	 * Change services coast.
	 *
	 * @param name the name
	 * @param coast the coast
	 */
	public void changeServicesCoast(String name, int coast){
		getServiceServ().changeStatus(name, coast);
	}
	
	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public List<RoomModel> getRooms(){
		return getRoomServ().getRooms();
	}			
	
	/**
	 * Adds the room.
	 *
	 * @param room the room
	 */
	public void addRoom(RoomModel room){
		getRoomServ().addRoom(room);
	}
	
	/**
	 * Delete room.
	 *
	 * @param room the room
	 */
	public void deleteRoom(int number){
		getRoomServ().deleteRoom(number);
	}
	
	/**
	 * Delete guest from room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(String name){
		getRoomServ().deleteGuestFromRoom(name);
	}
	
	/**
	 * Delete all guests from room.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestsFromRoom(int number){
		getRoomServ().deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(int number, int coast){
		getRoomServ().changeCoast(number, coast);
	}
	
	public void changeRoomsStatusRepair(){
		getRoomServ().changeStatusRepair();
	}
	
	/**
	 * Sort by coast free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastFreeRoom(){
		return getRoomServ().sortByCoastFreeRoom();
	}
	
	/**
	 * Sort by copasity free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityFreeRoom(){
		return getRoomServ().sortByCopasityFreeRoom();
	}
	
	/**
	 * Sort by stars free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsFreeRoom(){
		return getRoomServ().sortByStarsFreeRoom();
	}
	
	/**
	 * Sort by coast room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastRoom(){
		return getRoomServ().sortByCoastRoom();
	}
	
	/**
	 * Sort by copasity room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityRoom(){
		return getRoomServ().sortByCopasityRoom();
	}
	
	/**
	 * Sort by stars room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsRoom(){
		return getRoomServ().sortByStarsRoom();
	}
	
	/**
	 * Show number of free rooms.
	 *
	 * @return the int
	 */
	public int showNumberOfFreeRooms(){
		return getRoomServ().showFreeRooms();
	}
	
	/**
	 * Show chek out date.
	 *
	 * @param date the date
	 * @return the list
	 */
	public List<RoomModel> showChekOutDate(Date date){
		return getRoomServ().showChekOutDate(date);
	}
	
	/**
	 * Show room details.
	 *
	 * @param room the room
	 * @return the string
	 */
	public String showRoomDetails(int number){
		return getRoomServ().showRoomDetails(number);
	}
	
	/**
	 * Show price per room.
	 *
	 * @param guest the guest
	 * @return the string
	 */
	public String showPricePerRoom(String name){
		return getRoomServ().showPricePerRoom(name);
	}
	
	/**
	 * Show last three guests.
	 *
	 * @param room the room
	 * @return the string
	 */
	public String showLastThreeGuests(int number){
		return getRoomServ().showLastThreeGuests(number);
	}
	
	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	public void addServiceToGuest( String guest, String service){
		getGuestServ().addServiceToGuest(guest, service);
	}
	
	/**
	 * Adds the guest in room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void addGuestInRoom( int number, String name){
		getRoomServ().addGuestInRoom(number, name);
	}
	
	/**
	 * Write guests.
	 */
	/*
	public void writeGuests(){
		getGuestServ().writeGuests();
	}
	*/
	/**
	 * Write rooms.
	 */
	/*
	public void writeRooms(){
		getRoomServ().writeRooms();
	}
*/
	/**
	 * Write services.
	 */
	/*
	public void writeServices(){
		getRoomServ().writeRooms();
	}
	*/
	/**
	 * Show guests from file.
	 *
	 * @return the string
	 */
	/*
	public String showGuestsFromFile(){
		return getGuestServ().showGuestsFromFile();
	}
	*/
	/**
	 * Show rooms from file.
	 *
	 * @return the string
	 */
	/*
	public String showRoomsFromFile(){
		return getGuestServ().showGuestsFromFile();
	}
	*/
	/**
	 * Show services from file.
	 *
	 * @return the string
	 */
	/*
	public String showServicesFromFile(){
		return getServiceServ().showServicesFromFile();
	}
	*/
}
