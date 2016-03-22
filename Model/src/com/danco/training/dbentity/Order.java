package com.danco.training.dbentity;

public class Order extends BaseEntity{
	
	private static final long serialVersionUID = -284532234827294331L;
	private int guestId;
	private int serviceId;
	
	public Order(){
		super();
	}
	
	public Order(int id, int guestId, int serviceId){
		super(id);
		this.guestId = guestId;
		this.serviceId = serviceId;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
}
