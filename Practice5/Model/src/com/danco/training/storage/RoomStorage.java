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
		getListOfNumbers().add(room);
	}
	
	/**
	 * Delete number.
	 *
	 * @param room the room
	 */
	public void deleteNumber(int number){
		for(int i = 0 ; i < getListOfNumbers().size(); i++){
			if(number == getListOfNumbers().get(i).getNumber()){
				getListOfNumbers().remove(i);
			}
		}
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
	public void deleteGuestFromRoom(String name){
			for(int i = 0; i < getListOfNumbers().size(); i++){
				for(int j = 0; j < getListOfNumbers().get(i).getGuests().size(); j++)
				{
					if(name.equals(getListOfNumbers().get(i).getGuests().get(j).getName())){
						getListOfNumbers().get(i).getGuests().remove(j);
					}
				}
			}
	}
	
	/**
	 * Delete all guests.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestsFromRoom(int number){
		for(int i = 0; i < getListOfNumbers().size(); i++){
			if(number == getListOfNumbers().get(i).getNumber()){
				getListOfNumbers().get(i).getGuests().clear();
			}
		}
	}			
	
	
}
