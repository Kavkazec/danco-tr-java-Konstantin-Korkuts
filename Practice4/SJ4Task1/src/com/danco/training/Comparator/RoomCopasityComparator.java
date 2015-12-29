package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.RoomModel;

public class RoomCopasityComparator implements Comparator<RoomModel> {
	public int compare(RoomModel a, RoomModel b){
		return ((Integer)a.getCapacity()).compareTo((Integer)b.getCapacity());
	}
}
