package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.RoomModel;

public class FreeRoomStarsComparator implements Comparator<RoomModel> {
	public int compare(RoomModel a, RoomModel b){
		int t = 0;
		if(a.getStatus() == b.getStatus() == false){
			t = ((Integer)a.getNumberOfStars()).compareTo((Integer)b.getNumberOfStars());
		}
		return t;
	}
}
