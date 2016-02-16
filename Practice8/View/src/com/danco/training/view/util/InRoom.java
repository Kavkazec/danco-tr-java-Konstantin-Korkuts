package com.danco.training.view.util;

import com.danco.training.entity.RoomModel;

public class InRoom {
	public static RoomModel inputRoom(){
		InReader.print("Number:");
		int number = InReader.readInt();
		InReader.print("Capasity:");
		int capacity = InReader.readInt();
		InReader.print("Number of stars:");
		int numberOfStars = InReader.readInt();
		InReader.print("Coast:");
		int coast = InReader.readInt();
		RoomModel rm = new RoomModel(number, capacity, numberOfStars, coast);
		return rm;
	}
}
