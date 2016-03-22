package com.danco.training.dbentity;

public class Room extends BaseEntity {
	
	private static final long serialVersionUID = -5339484064824529456L;
	private int number;
	private int capasity;
	private int numberOfStars;
	private int coast;
	private boolean isFreeRoom;
	private boolean isOnRepair;
	
	public Room(){
		super();
	}
	
	public Room(int id, int number, int capasity, int numberOfStars, int coast, boolean isOnRepair){
		super(id);
		this.number = number;
		this.capasity = capasity;
		this.numberOfStars = numberOfStars;
		this.coast = coast;
		this.isOnRepair = isOnRepair;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCapasity() {
		return capasity;
	}
	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}
	public int getNumberOfStars() {
		return numberOfStars;
	}
	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}
	public int getCoast() {
		return coast;
	}
	public void setCoast(int coast) {
		this.coast = coast;
	}
	public boolean isFreeRoom() {
		return isFreeRoom;
	}
	public void setFreeRoom(boolean isFreeRoom) {
		this.isFreeRoom = isFreeRoom;
	}
	public boolean isOnRepair() {
		return isOnRepair;
	}
	public void setOnRepair(boolean isOnRepair) {
		this.isOnRepair = isOnRepair;
	}
}
