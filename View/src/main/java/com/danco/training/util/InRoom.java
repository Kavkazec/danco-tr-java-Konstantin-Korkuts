package com.danco.training.util;

import com.danco.training.entity.Room;

public class InRoom {
	private static final String ID2 = "ID:";
	private static final String IS_FREE_ROOM = "Is free room?:";
	private static final String IS_ON_REPAIR = "Is on repair?:";
	private static final String COAST2 = "Coast:";
	private static final String NUMBER_OF_STARS = "Number of stars:";
	private static final String CAPASITY = "Capasity:";
	private static final String NUMBER2 = "Number:";

	public static Room inputRoom(){
		InReader.print(NUMBER2);
		int number = InReader.readInt();
		InReader.print(CAPASITY);
		int capacity = InReader.readInt();
		InReader.print(NUMBER_OF_STARS);
		int numberOfStars = InReader.readInt();
		InReader.print(COAST2);
		int coast = InReader.readInt();
		InReader.print(IS_ON_REPAIR);
		boolean isOnRepair = InReader.readBoolean();
		Room rm = new Room(number, capacity, numberOfStars, coast, isOnRepair);
		return rm;
	}
	
	public static Room inputRoomWithID(){
		InReader.print(ID2);
		int id = InReader.readInt();
		InReader.print(NUMBER2);
		int number = InReader.readInt();
		InReader.print(CAPASITY);
		int capacity = InReader.readInt();
		InReader.print(NUMBER_OF_STARS);
		int numberOfStars = InReader.readInt();
		InReader.print(COAST2);
		int coast = InReader.readInt();
		InReader.print(IS_FREE_ROOM);
		boolean isFreeRoom = InReader.readBoolean();
		InReader.print(IS_ON_REPAIR);
		boolean isOnRepair = InReader.readBoolean();
		Room rm = new Room(id, number, capacity, numberOfStars, coast, isOnRepair);
		rm.setFreeRoom(isFreeRoom);
		return rm;
	}
}
