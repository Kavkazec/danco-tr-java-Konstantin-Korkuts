package com.danco.training.entity;

public class Room extends BaseEntity {
	
	private static final long serialVersionUID = -5339484064824529456L;
	private int number;
	private int capacity;
	private int numberOfStars;
	private int coast;
	private boolean isFreeRoom;
	private boolean isOnRepair;
	
	public Room(int number, int capacity, int numberOfStars, int coast, boolean isOnRepair){
		super();
		this.number = number;
		this.capacity = capacity;
		this.numberOfStars = numberOfStars;
		this.coast = coast;
		this.isOnRepair = isOnRepair;
	}
	
	public Room(int id, int number, int capacity, int numberOfStars, int coast, boolean isOnRepair){
		super(id);
		this.number = number;
		this.capacity = capacity;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capasity) {
		this.capacity = capasity;
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
	public Room clone() throws CloneNotSupportedException {
        return (Room)super.clone();
	}
}
