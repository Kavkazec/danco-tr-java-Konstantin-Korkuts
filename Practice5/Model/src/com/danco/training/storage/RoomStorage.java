package com.danco.training.storage;


import java.util.ArrayList;
import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomStorage.
 */
public class RoomStorage{
	
	/** The rooms. */
	private List<RoomModel> rooms;
	
	
	
	/**
	 * Adds the number.
	 *
	 * @param room the room
	 */
	public void addNumber(RoomModel room){
		rooms.add(room);
	}
	
	/**
	 * Delete number.
	 *
	 * @param room the room
	 */
	public void deleteNumber(RoomModel room){
		if(rooms.contains(room)){
			rooms.remove(room);
		}
	}
	
	/**
	 * Update number.
	 *
	 * @param room the room
	 * @param numberOfStars the number of stars
	 */
	public void updateNumber(RoomModel room, int numberOfStars){
			room.setNumberOfStars(numberOfStars);
	}
	
	/**
	 * Gets the list of numbers.
	 *
	 * @return the list of numbers
	 */
	public List<RoomModel> getListOfNumbers(){
		if(rooms == null){
			rooms = new ArrayList<RoomModel>();
		}
		return rooms;
	}
	
	/**
	 * Delete guest.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(RoomModel room, GuestModel guest){
			for(int j = 0; j < room.getGuests().size(); j++)
			{
				if(room.getGuests().get(j) == guest)
				{
					room.getGuests().remove(j);
				}
			}
	}
	
	/**
	 * Delete all guests.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestsFromRoom(RoomModel room){
			room.getGuests().clear();
	}
	
	
}
