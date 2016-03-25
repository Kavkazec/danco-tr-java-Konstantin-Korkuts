package com.danco.training.view.util;

import java.util.List;

import com.danco.training.entity.Room;

public class PrintRoom {
	private static final String SEPAR = " ; ";
	public static void printRooms(List<Room> list){
		for (Room room : list) {
			InReader.print(room.getId() + SEPAR  + room.getNumber() + SEPAR  + room.getCapacity() + SEPAR  + room.getNumberOfStars()
			+ SEPAR + room.getCoast() + SEPAR  + room.isFreeRoom() + SEPAR  + room.isOnRepair());
		}
	}
}
