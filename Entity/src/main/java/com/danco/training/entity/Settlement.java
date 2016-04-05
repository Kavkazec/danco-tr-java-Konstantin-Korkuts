package com.danco.training.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room_guests")
public class Settlement extends BaseEntity{
	
	private static final long serialVersionUID = -1536940568158081361L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_model_id")
	private Room room;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guest_model_id")
	private Guest guest;
	
	@Column(name="date_arrive")
	private Date dateOfArrival;
	
	@Column(name="date_departure")
	private Date dateOfDeparture;
	
	@OneToMany(targetEntity=com.danco.training.entity.Service.class, mappedBy="settlement")
	private List<Service> serviceList;
	
	@Column(name="service_date")
	private Date serviceDateOfAdd;
	
	@Column(name="is_paid")
	private boolean isPaid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="service_model_id")
	private Service service;
	
	public Settlement(){
		
	}
	
	public Settlement(Room room, Guest guest, Service service, Date dateOfArrival, Date dateOfDeparture, Date serviceDateOfAdd,
			boolean isPaid){
		super();
		this.room = room;
		this.guest = guest;
		this.service = service;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.serviceDateOfAdd = serviceDateOfAdd;
		this.isPaid = isPaid;
	}
	
	public Settlement(int id, Room room, Guest guest, Service service,  Date dateOfArrival, Date dateOfDeparture, Date serviceDateOfAdd,
			boolean isPaid){
		super(id);
		this.room = room;
		this.guest = guest;
		this.service = service;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.serviceDateOfAdd = serviceDateOfAdd;
		this.isPaid = isPaid;
	}

	
	
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getServiceDateOfAdd() {
		return serviceDateOfAdd;
	}

	public void setServiceDateOfAdd(Date serviceDateOfAdd) {
		this.serviceDateOfAdd = serviceDateOfAdd;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
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