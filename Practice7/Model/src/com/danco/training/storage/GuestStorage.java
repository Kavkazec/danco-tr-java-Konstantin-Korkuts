package com.danco.training.storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.entity.GuestModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestStorage.
 */
public class GuestStorage  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The sdf. */
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
		getGuests().add(guest);
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(String name){
		for(int i = 0; i < getGuests().size(); i++){
			if(name.equals(getGuests().get(i).getName())){
				getGuests().remove(i);
			}
		}
	}
}
