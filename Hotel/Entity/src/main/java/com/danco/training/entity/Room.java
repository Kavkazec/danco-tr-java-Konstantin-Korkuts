package com.danco.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="room_model")
public class Room extends BaseEntity implements Cloneable {
	
	private static final long serialVersionUID = -5339484064824529456L;
	
	@Column(name="room_number")
	private int number;
	
	@Column(name="capasity")
	private int capacity;
	
	@Column
	private int numberOfStars;
	
	@Column
	private int coast;
	
	@Column
	private boolean isFreeRoom = true;
	
	@Column
	private boolean isOnRepair;
	
	@Column
	private String type = "room";
	
	public Room(){
		
	}

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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
        return (Room) super.clone();
	}
}
