package com.danco.training.Storage;

import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Model.ServiceModel;

public class Hotel {
	private GuestStorage guest;
	private RoomStorage room;
	private ServiceStorage service;
	public Hotel(){
		guest = GuestStorage.getInstance();
		room = RoomStorage.getInstance();
		service = ServiceStorage.getInstance();
	}
	private static Hotel instance;
	public static Hotel getInstance(){
		if(instance == null){
			instance = new Hotel();
		}
		return instance;
	}
	public GuestStorage getGuest() {
		return guest;
	}
	public void setGuest(GuestModel guest) {
		this.guest.addGuests(guest);;
	}
	public RoomStorage getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room.addNumber(room);
	}
	public ServiceStorage getService() {
		return service;
	}
	public void setService(ServiceModel service) {
		this.service.addService(service);
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
