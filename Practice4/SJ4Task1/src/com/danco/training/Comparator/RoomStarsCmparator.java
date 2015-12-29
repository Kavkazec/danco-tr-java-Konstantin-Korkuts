package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.RoomModel;

public class RoomStarsCmparator implements Comparator<RoomModel> {
	public int compare(RoomModel a, RoomModel b){
		return ((Integer)a.getNumberOfStars()).compareTo((Integer)b.getNumberOfStars());
	}
}
