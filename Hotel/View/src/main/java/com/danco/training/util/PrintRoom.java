package com.danco.training.util;

import java.util.List;

import com.danco.training.entity.Room;

public class PrintRoom {
	private static final String SEPAR = " ; ";
	public static void printRooms(List<Room> list){
		for (Room room : list) {
			StringBuilder sb = new StringBuilder();
			sb.append(room.getId());
			sb.append(SEPAR);
			sb.append(room.getNumber());
			sb.append(SEPAR);
			sb.append(room.getCapacity());
			sb.append(SEPAR);
			sb.append(room.getNumberOfStars());
			sb.append(SEPAR);
			sb.append(room.getCoast());
			sb.append(SEPAR);
			sb.append(room.isFreeRoom());
			sb.append(SEPAR);
			sb.append(room.isOnRepair());
			sb.append(SEPAR);
			sb.append(room.getType());
			sb.append(SEPAR);
			InReader.print(sb.toString());
		}
	}
}
