package com.danco.training.Storage;

import java.io.Serializable;
import java.text.ParseException;

import com.danco.training.TextFileWorker;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Model.ServiceModel;
import com.danco.training.Parser.TextParser;

// TODO: Auto-generated Javadoc
/**
 * The Class Hotel.
 */
public class Hotel implements Serializable{
	
	/** The guest. */
	private GuestStorage guest;
	
	/** The room. */
	private RoomStorage room;
	
	/** The service. */
	private ServiceStorage service;
	
	/**
	 * Instantiates a new hotel.
	 */
	public Hotel(){
		guest = GuestStorage.getInstance();
		room = RoomStorage.getInstance();
		service = ServiceStorage.getInstance();
	}
	
	final String FILE_PATH_ROOMS = "src/files/rooms.txt";
	final String FILE_PATH_GUESTS = "src/files/guests.txt";
	final String FILE_PATH_SERVICES = "src/files/services.txt";
	TextFileWorker tfw1 = new TextFileWorker(FILE_PATH_ROOMS);
	TextParser textParser1 = new TextParser(tfw1);
	
	TextFileWorker tfw2 = new TextFileWorker(FILE_PATH_GUESTS);
	TextParser textParser2 = new TextParser(tfw2);
	
	TextFileWorker tfw3 = new TextFileWorker(FILE_PATH_SERVICES);
	TextParser textParser3 = new TextParser(tfw3);
	
	/** The instance. */
	private static Hotel instance;
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public void addGuestInRoom(GuestModel guest, RoomModel room ){
		if(room.getGuests().size() < room.getCapacity()){
			room.setGuests(guest);
		} else {
			System.out.print("Is room" + room +" full? -  "+room.getStatus()+ "\n");
		}
	}
	
	public void addServiceToGuest(ServiceModel service, GuestModel guest){
		guest.setServices(service);
	}
	
	public void writeGuests(){
		textParser2.writeToFile(getGuest().getGuests());
	}
	public void writeRooms(){
		textParser1.writeToFile(getRoom().getListOfNumbers());
	}
	public void writeServices(){
		textParser3.writeToFile(getService().getListOfServices());
	}
	
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
	
	public String showRoomsFromFile(){
		String str = "";
		for(int i = 0; i < textParser1.readRooms().size(); i++){
			str = str +  textParser1.readRooms().get(i).toString() + "\n";
		}
		return str;
	}
	
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.guest.toString() + System.lineSeparator()
			+ System.lineSeparator());
		sb.append(this.room.toString() + System.lineSeparator()
			+ System.lineSeparator());
		sb.append(this.service.toString() + System.lineSeparator()
			+ System.lineSeparator());
		return sb.toString();
	    }
}
