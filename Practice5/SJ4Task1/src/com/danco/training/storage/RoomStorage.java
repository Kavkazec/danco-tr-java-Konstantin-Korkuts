package com.danco.training.storage;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomStorage.
 */
public class RoomStorage implements Serializable{
	
	/** The rooms. */
	private List<RoomModel> rooms = new ArrayList<RoomModel>();
	
	/** The instance. */
	private static RoomStorage instance;
	
	/**
	 * Gets the single instance of RoomStorage.
	 *
	 * @return single instance of RoomStorage
	 */
	public static RoomStorage getInstance() {
		if (instance == null) {
			instance = new RoomStorage();
		}
		return instance;
	}
	
	/**
	 * Adds the number.
	 *
	 * @param room the room
	 */
	public void addNumber(RoomModel room){
		rooms.add(room);
	}
	
	/**
	 * Gets the list of numbers.
	 *
	 * @return the list of numbers
	 */
	public List<RoomModel> getListOfNumbers(){
		return rooms;
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(GuestModel guest){
		for(int i = 0; i < rooms.size();i++)
			for(int j = 0; j < rooms.get(i).getGuests().size(); j++)
			{
				if(rooms.get(i).getGuests().get(j) == guest)
				{
					rooms.get(i).getGuests().remove(j);
				}
			}
	}
	
	/**
	 * Delete all guests.
	 */
	public void deleteAllGuests(){
		for(int i = 0; i < rooms.size();i++)
			for(int j = 0; j < rooms.get(i).getGuests().size(); j++)
			{
					rooms.get(i).getGuests().clear();
			}
	}
	
	
}
