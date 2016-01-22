package com.danco.training.storage;

import java.text.ParseException;
import java.util.GregorianCalendar;

import com.danco.training.TextFileWorker;
import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.parser.TextParser;

// TODO: Auto-generated Javadoc
/**
 * The Class Hotel.
 */
public class Hotel{
	
	/** The guest. */
	private GuestStorage guest;
	
	/** The room. */
	private RoomStorage room;
	
	/** The service. */
	private ServiceStorage service;
	
	/** The file path rooms. */
	final String FILE_ROOMS = "rooms.txt";
	
	/** The file path guests. */
	final String FILE_GUESTS = "guests.txt";
	
	/** The file path services. */
	final String FILE_SERVICES = "services.txt";
	
	/** The tfw1. */
	 TextFileWorker tfw1 = new TextFileWorker(FILE_ROOMS);
	
	/** The text parser1. */
	TextParser textParser1 = new TextParser(tfw1);
	
	/** The tfw2. */
	TextFileWorker tfw2 = new TextFileWorker(FILE_GUESTS);
	
	/** The text parser2. */
	TextParser textParser2 = new TextParser(tfw2);
	
	/** The tfw3. */
	TextFileWorker tfw3 = new TextFileWorker(FILE_SERVICES);
	
	/** The text parser3. */
	TextParser textParser3 = new TextParser(tfw3);
	
	/** The instance. */
	private static Hotel instance = null;
	
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
	
	/**
	 * Write guests.
	 */
	
	public void writeGuests(){
		textParser2.writeToFile(getGuest().getGuests());
	}
	
	/**
	 * Write services.
	 */
	
	public void writeServices(){
		textParser3.writeToFile(getService().getListOfServices());
	}
	
	/**
	 * Show guests from file.
	 *
	 * @return the string
	 */
	
	public String showGuestsFromFile(){
		String str = "";
		try {
			for(int i = 0; i < textParser2.readGuests().size(); i++)
				str = str + textParser2.readGuests().get(i).toString() + "\n";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * Show rooms from file.
	 *
	 * @return the string
	 */
	
	public void writeToFileRooms(){
		textParser1.writeToFile(getRoom().getListOfNumbers());
	}
	
	public String showRoomsFromFile(){
		String str = "";
		for(int i = 0; i < textParser1.readRooms().size(); i++){
			str = str +  textParser1.readRooms().get(i).toString() + "\n";
		}
		return str;
	}
	
	/**
	 * Show services from file.
	 *
	 * @return the string
	 */
	
	public String showServicesFromFile(){
		String str = "";
		try {
			for(int i = 0; i < textParser3.readServices().size(); i++){
				str =str +  textParser3.readServices().get(i).toString() + "\n";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public void cloneRoom(int number) throws CloneNotSupportedException{
		getRoom().cloneRoom(number);
	}
	
	
}
