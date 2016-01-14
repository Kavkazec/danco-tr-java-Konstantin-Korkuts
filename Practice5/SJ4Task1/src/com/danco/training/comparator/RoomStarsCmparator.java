package com.danco.training.comparator;

import java.util.Comparator;

import com.danco.training.model.RoomModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomStarsCmparator.
 */
public class RoomStarsCmparator implements Comparator<RoomModel> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(RoomModel a, RoomModel b){
		return ((Integer)a.getNumberOfStars()).compareTo((Integer)b.getNumberOfStars());
	}
}
