package com.danco.training.Comparator;

import java.util.Comparator;

import com.danco.training.Model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestServicesDateCopmarator.
 */
public class GuestServicesDateCopmarator implements Comparator<ServiceModel> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(ServiceModel a, ServiceModel b){
		return a.getDate().compareTo(b.getDate());
	}
}