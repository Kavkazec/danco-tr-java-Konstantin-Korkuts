package com.danco.training.entity;

import java.util.Date;
import java.util.List;

public class Settlement extends BaseEntity{
	
	private static final long serialVersionUID = -1536940568158081361L;
	private Guest guest;
	private Room room;
	private Service service;
	private Date dateOfArrival;
	private Date dateOfDeparture;
	private List<Service> serviceList;
	
	public Settlement(Room room, Guest guest, Service service, Date dateOfArrival, Date dateOfDeparture){
		super();
		this.room = room;
		this.guest = guest;
		this.service = service;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
	}
	
	public Settlement(int id, Room room, Guest guest, Service service, Date dateOfArrival, Date dateOfDeparture){
		super(id);
		this.room = room;
		this.guest = guest;
		this.service = service;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	
	
}