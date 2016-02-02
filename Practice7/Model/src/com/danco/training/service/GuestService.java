package com.danco.training.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.danco.training.comparator.GuestDateComparator;
import com.danco.training.comparator.GuestNameComparator;
import com.danco.training.comparator.GuestServicesCoastComparator;
import com.danco.training.comparator.GuestServicesDateCopmarator;
import com.danco.training.model.GuestModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.storage.Hotel;


// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */

public class GuestService {
	
	
	
	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel =  Hotel.getInstance();

	/**
	 * Instantiates a new guest service.
	 */
	
	/**
	 * Sort by name.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
		return hotel.getGuest().getGuests();
	}
	
	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	public void addGuest(GuestModel guest) {
		hotel.addGuest(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(String str){
		hotel.deleteGuest(str);
	}
	
	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	public void addServiceToGuest( String guest, String service){
		hotel.addServiceToGuest(guest, service);
	}
	
	
	/**
	 * Sort by name.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByName(){
	
			Collections.sort(hotel.getGuest().getGuests(), new GuestNameComparator());
			return hotel.getGuest().getGuests();
	}
	
	/**
	 * Sort by date.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByDate(){
		Collections.sort(hotel.getGuest().getGuests(), new GuestDateComparator());
		return hotel.getGuest().getGuests();
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
	public List<ServiceModel> showListOfServicesSortedByCoast(String name){
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		for(GuestModel gm : hotel.getGuest().getGuests()){
			if(name.equals(gm.getName())){
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
	public List<ServiceModel> showListOfServicesSortedByDate(String name){
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		for(GuestModel gm : hotel.getGuest().getGuests()){
			if(name.equals(gm.getName())){
				for(ServiceModel sm : gm.getServices()){
					list.add(sm);
				}
			}
		}
		Collections.sort(list, new GuestServicesDateCopmarator());
		return list;
	}
	
	public void exportGuests(String path){
		ImportAndExport.getInstance().writeToFileGuests(path);
	}
	
	public void importGuests(String path){
		ImportAndExport.getInstance().readFromFileGuests(path);
	}
	
	public List<ServiceModel> getService(String name){
		List<ServiceModel> list = new ArrayList<ServiceModel>();
		for(GuestModel gm : hotel.getGuest().getGuests()){
			if(name.equals(gm.getName())){
				for(ServiceModel sm : gm.getServices()){
					list.add(sm);
				}
			}
		}
		return list;
	}
}
