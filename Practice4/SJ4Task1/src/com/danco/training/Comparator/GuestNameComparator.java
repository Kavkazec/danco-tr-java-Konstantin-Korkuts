package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.GuestModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestNameComparator.
 */
public class GuestNameComparator implements Comparator<GuestModel> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(GuestModel a, GuestModel b){
		return a.getName().compareTo(b.getName());
	}
}
