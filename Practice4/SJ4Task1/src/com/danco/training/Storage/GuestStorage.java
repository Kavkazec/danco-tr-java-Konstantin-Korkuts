package com.danco.training.Storage;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.Model.GuestModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestStorage.
 */
public class GuestStorage {
	
	/** The guests. */
	private List<GuestModel> guests = new ArrayList<GuestModel>();
	
	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
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
	
	/** The instance. */
	private static GuestStorage instance;

	/**
	 * Gets the single instance of GuestStorage.
	 *
	 * @return single instance of GuestStorage
	 */
	public static GuestStorage getInstance() {
		if (instance == null) {
			instance = new GuestStorage();
		}
		return instance;
	}
	
}
