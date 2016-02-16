package com.danco.training.view.util;

import java.util.List;

import com.danco.training.entity.RoomModel;

public class PrintRoom {
	private static final String SEPAR = " ; ";
	public static void printRooms(List<RoomModel> list){
		for(int i = 0; i < list.size(); i++){
			InReader.print(list.get(i).getNumber() + SEPAR +  list.get(i).getCapacity()
					+ SEPAR + list.get(i).getNumberOfStars() + SEPAR + list.get(i).getCoast()
					+ SEPAR + list.get(i).getStatus() + SEPAR + list.get(i).getIsOnRepair() + SEPAR);
		}
	}
}
