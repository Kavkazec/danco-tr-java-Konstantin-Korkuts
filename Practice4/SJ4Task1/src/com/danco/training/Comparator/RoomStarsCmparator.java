package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.RoomModel;

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
