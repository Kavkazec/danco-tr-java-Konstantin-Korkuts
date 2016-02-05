package com.danco.training.comparator;

import java.util.Comparator;

import com.danco.training.entity.RoomModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FreeRoomCoastComparator.
 */
public class FreeRoomCoastComparator implements Comparator<RoomModel> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(RoomModel a, RoomModel b){
		int t = 0;
		if(!a.getStatus() && !b.getStatus()){
			t = ((Integer)a.getCoast()).compareTo((Integer)b.getCoast());
		} 
		return t;
	}
}
