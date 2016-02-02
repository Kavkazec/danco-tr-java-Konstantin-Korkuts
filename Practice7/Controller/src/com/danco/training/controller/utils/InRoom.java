package com.danco.training.controller.utils;

import com.danco.training.model.RoomModel;

public class InRoom {
	public RoomModel inputRoom(){
		InReader input = new InReader();
		input.print("Number:");
		int number = input.readInt();
		input.print("Capasity:");
		int capacity = input.readInt();
		input.print("Number of stars:");
		int numberOfStars = input.readInt();
		input.print("Coast:");
		int coast = input.readInt();
		return new RoomModel(number, capacity, numberOfStars, coast);
	}
}
