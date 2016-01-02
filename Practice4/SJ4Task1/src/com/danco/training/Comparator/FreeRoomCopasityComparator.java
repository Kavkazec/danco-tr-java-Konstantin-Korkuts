package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.RoomModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FreeRoomCopasityComparator.
 */
public class FreeRoomCopasityComparator implements Comparator<RoomModel> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(RoomModel a, RoomModel b){
		int t = 0;
		if(!a.getStatus() && !b.getStatus()){
			t = ((Integer)a.getCapacity()).compareTo((Integer)b.getCapacity());
		}
		return t;
	}
}
