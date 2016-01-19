package com.danco.training.storage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.model.GuestModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestStorage.
 */
public class GuestStorage{
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	/** The guests. */
	private List<GuestModel> guests;
	
	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
		if(guests == null){
			guests = new ArrayList<GuestModel>();
		}
		return guests;
	}
	
	/**
	 * Adds the guests.
	 *
	 * @param guest the guest
	 */
	public void addGuests(GuestModel guest) {
		guests.add(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(GuestModel guest){
		if(guests.contains(guest)){
			guests.remove(guest);
		}
	}
	
	/**
	 * Update guest.
	 *
	 * @param guest the guest
	 * @param dateOfAdd the date of add
	 * @param dateOfEvi the date of evi
	 */
	public void updateGuest(GuestModel guest, String dateOfAdd, String dateOfEvi ){
		try {
			guest.setDateAdd(sdf.parse(dateOfAdd));
			guest.setDateEvi(sdf.parse(dateOfEvi));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
