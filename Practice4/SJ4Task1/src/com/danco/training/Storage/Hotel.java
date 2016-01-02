package com.danco.training.Storage;


// TODO: Auto-generated Javadoc
/**
 * The Class Hotel.
 */
public class Hotel {
	
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
	public void setGuest(GuestStorage guest) {
		this.guest = guest;
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
	public void setRoom(RoomStorage room) {
		this.room = room;
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
	public void setService(ServiceStorage service) {
		this.service = service;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
