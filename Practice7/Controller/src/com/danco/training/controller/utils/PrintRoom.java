package com.danco.training.controller.utils;

import java.util.List;

import com.danco.training.model.RoomModel;

public class PrintRoom {
	private static final String SEPAR = " ; ";
	private InReader reader = new InReader();
	public void printRooms(List<RoomModel> list){
		for(int i = 0; i < list.size(); i++){
			reader.print(list.get(i).getNumber() + SEPAR +  list.get(i).getCapacity()
					+ SEPAR + list.get(i).getNumberOfStars() + SEPAR + list.get(i).getCoast()
					+ SEPAR + list.get(i).getStatus() + SEPAR + list.get(i).getIsOnRepair() + SEPAR);
		}
	}
}
