package com.danco.training.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.danco.training.Comparator.GuestDateComparator;
import com.danco.training.Comparator.GuestNameComparator;
import com.danco.training.Comparator.GuestServicesCoastComparator;
import com.danco.training.Comparator.GuestServicesDateCopmarator;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.ServiceModel;
import com.danco.training.Storage.Hotel;


// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */
public class GuestService {
	
	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel;
	
	/**
	 * Instantiates a new guest service.
	 */
	public GuestService(){
		hotel =  Hotel.getInstance();
	}
	
	/**
	 * Sort by name.
	 */
	public void sortByName(){
		Collections.sort(hotel.getGuest().getGuests(), new GuestNameComparator());
	}
	
	/**
	 * Sort by date.
	 */
	public void sortByDate(){
		Collections.sort(hotel.getGuest().getGuests(), new GuestDateComparator());
	}
	
	/**
	 * Show all guests.
	 *
	 * @return the int
	 */
	public int showAllGuests(){
		for(int i = 0; i < hotel.getGuest().getGuests().size(); i++){
			t +=1;
		}		
		return t;
	}
	
	/**
	 * Show list of services sorted by coast.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showListOfServicesSortedByCoast(GuestModel guest){
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		for(GuestModel gm : hotel.getGuest().getGuests()){
			if(gm.equals(guest)){
				for(ServiceModel sm : gm.getServices()){
					list.add(sm);
				}
			}
		}
		Collections.sort(list, new GuestServicesCoastComparator());
		return list;
	}
	
	/**
	 * Show list of services sorted by date.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showListOfServicesSortedByDate(GuestModel guest){
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		for(GuestModel gm : hotel.getGuest().getGuests()){
			if(gm.equals(guest)){
				for(ServiceModel sm : gm.getServices()){
					list.add(sm);
				}
			}
		}
		Collections.sort(list, new GuestServicesDateCopmarator());
		return list;
	}
	
}