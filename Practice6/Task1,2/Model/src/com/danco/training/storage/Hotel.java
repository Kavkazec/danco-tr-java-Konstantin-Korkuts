package com.danco.training.storage;

import java.io.Serializable;
import java.util.GregorianCalendar;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Hotel.
 */
public class Hotel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The guest. */
	private GuestStorage guest;
	
	/** The room. */
	private RoomStorage room;
	
	/** The service. */
	private ServiceStorage service;
	
	/** The instance. */
	private static Hotel instance;
	
	private Hotel(){
		
	}
	/**
	 * Gets the single instance of Hotel.
	 *
	 * @return single instance of Hotel
	 */
	public static Hotel getInstance(){
		if(instance == null){
			instance = new Hotel();
		}
		return instance;
	}
	
	public void setHotel(Hotel hotel){
		instance = hotel;
	}
	
	/**
	 * Gets the guest.
	 *
	 * @return the guest
	 */
	public GuestStorage getGuest() {
		if(guest == null){
			guest = new GuestStorage();
		}
		return guest;
	}
	
	public void setGuest(GuestStorage guest) {
		this.guest = guest;
	}
	public void setRoom(RoomStorage room) {
		this.room = room;
	}
	public void setService(ServiceStorage service) {
		this.service = service;
	}
	/**
	 * Sets the guest.
	 *
	 * @param guest the new guest
	 */
	public void addGuest(GuestModel guest) {
		getGuest().addGuests(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(String str){
		getGuest().deleteGuest(str);
	}
	
	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public RoomStorage getRoom() {
		if(room == null){
			room = new RoomStorage();
		}
		return room;
	}
	
	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	public void addRoom(RoomModel room) {
		getRoom().addNumber(room);
	}
	
	/**
	 * Delete room.
	 *
	 * @param room the room
	 */
	public void deleteRoom(int number){
		getRoom().deleteNumber(number);
	}

	
	/**
	 * Delete guest from room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(String name){
		getRoom().deleteGuestFromRoom(name);
	}
	
	/**
	 * Delete all guest from room.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestFromRoom(int number){
		getRoom().deleteAllGuestsFromRoom(number);
	}
	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public ServiceStorage getService() {
		if(service == null){
			service = new ServiceStorage();
		}
		return service;
	}
	
	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	public void addService(ServiceModel service) {
		getService().addService(service);
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(String name) {
		getService().deleteService(name);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	/**
	 * Adds the guest in room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	
	public void addGuestInRoom(int number, String name){
		for(int i = 0; i < getRoom().getListOfNumbers().size(); i++){
			for(int j = 0; j < getGuest().getGuests().size(); j++){
				if(number == getRoom().getListOfNumbers().get(i).getNumber() && name.equals(getGuest().getGuests().get(j).getName())){
					getRoom().getListOfNumbers().get(i).setGuests(getGuest().getGuests().get(j));
				}
			}
		}
	}
	
	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	public void addServiceToGuest(String guest, String service){
		for(int i = 0; i < getGuest().getGuests().size(); i++){
			for(int j = 0; j < getService().getListOfServices().size(); j++){
				if(guest.equals(getGuest().getGuests().get(i).getName()) && service.equals(getService().getListOfServices().get(j).getName())){
					getGuest().getGuests().get(i).setServices(getService().getListOfServices().get(j));
					getService().getListOfServices().get(j).setDate(new GregorianCalendar().getTime());
				}
			}
		}
	}
	
	public void cloneRoom(int number) throws CloneNotSupportedException{
		getRoom().cloneRoom(number);
	}
	
	
}
