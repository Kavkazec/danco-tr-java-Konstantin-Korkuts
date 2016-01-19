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
	private GuestStorage guest = new GuestStorage();
	
	/** The room. */
	private RoomStorage room = new RoomStorage();
	
	/** The service. */
	private ServiceStorage service = new ServiceStorage();
	
	/** The file path rooms. */
	final String FILE_PATH_ROOMS = "src/files/rooms.txt";
	
	/** The file path guests. */
	final String FILE_PATH_GUESTS = "src/files/guests.txt";
	
	/** The file path services. */
	final String FILE_PATH_SERVICES = "src/files/services.txt";
	
	/** The tfw1. */
	private TextFileWorker tfw1 = new TextFileWorker(FILE_PATH_ROOMS);
	
	/** The text parser1. */
	private TextParser textParser1 = new TextParser(tfw1);
	
	/** The tfw2. */
	private TextFileWorker tfw2 = new TextFileWorker(FILE_PATH_GUESTS);
	
	/** The text parser2. */
	private TextParser textParser2 = new TextParser(tfw2);
	
	/** The tfw3. */
	private TextFileWorker tfw3 = new TextFileWorker(FILE_PATH_SERVICES);
	
	/** The text parser3. */
	private TextParser textParser3 = new TextParser(tfw3);
	
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
		return guest;
	}
	
	/**
	 * Sets the guest.
	 *
	 * @param guest the new guest
	 */
	public void addGuest(GuestModel guest) {
		this.guest.addGuests(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(GuestModel guest){
		this.guest.deleteGuest(guest);
	}
	
	/**
	 * Update guest.
	 *
	 * @param guest the guest
	 * @param dateOfAdd the date of add
	 * @param dateOfEvi the date of evi
	 */
	public void updateGuest(GuestModel guest, String dateOfAdd, String dateOfEvi){
		this.guest.updateGuest(guest, dateOfAdd, dateOfEvi);
	}
	
	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public RoomStorage getRoom() {
		return room;
	}
	
	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	public void addRoom(RoomModel room) {
		this.room.addNumber(room);
	}
	
	/**
	 * Delete room.
	 *
	 * @param room the room
	 */
	public void deleteRoom(RoomModel room){
		this.room.deleteNumber(room);
	}
	
	/**
	 * Update room.
	 *
	 * @param room the room
	 * @param numberOfStars the number of stars
	 */
	public void updateRoom(RoomModel room, int numberOfStars){
		this.room.updateNumber(room, numberOfStars);
	}
	
	/**
	 * Delete guest from room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(RoomModel room, GuestModel guest){
		this.room.deleteGuestFromRoom(room, guest);
	}
	
	/**
	 * Delete all guest from room.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestFromRoom(RoomModel room){
		this.room.deleteAllGuestsFromRoom(room);
	}
	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public ServiceStorage getService() {
		return service;
	}
	
	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	public void addService(ServiceModel service) {
		this.service.addService(service);
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(ServiceModel service) {
		this.service.deleteService(service);
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
	public void addGuestInRoom( RoomModel room , GuestModel guest){
		if(room.getGuests().size() < room.getCapacity()){
			room.setGuests(guest);
		} else {
			System.out.print("Is room" + room +" full? -  "+room.getStatus()+ "\n");
		}
	}
	
	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	public void addServiceToGuest(GuestModel guest, ServiceModel service){
		guest.setServices(service);
		service.setDate(new GregorianCalendar().getTime());
	}
	
	/**
	 * Write guests.
	 */
	public void writeGuests(){
		textParser2.writeToFile(getGuest().getGuests());
	}
	
	/**
	 * Write rooms.
	 */
	public void writeRooms(){
		textParser1.writeToFile(getRoom().getListOfNumbers());
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
}
