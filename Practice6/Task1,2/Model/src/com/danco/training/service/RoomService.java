package com.danco.training.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.comparator.FreeRoomCoastComparator;
import com.danco.training.comparator.FreeRoomCopasityComparator;
import com.danco.training.comparator.FreeRoomStarsComparator;
import com.danco.training.comparator.RoomCoastComparator;
import com.danco.training.comparator.RoomCopasityComparator;
import com.danco.training.comparator.RoomStarsCmparator;
import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.storage.Hotel;



// TODO: Auto-generated Javadoc
/**
 * The Class RoomService.
 */
public class RoomService {
	
	private PropertiesReader reader = new PropertiesReader();

	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel = Hotel.getInstance();
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Instantiates a new room service.
	 */
	
	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public List<RoomModel> getRooms(){
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Adds the room.
	 *
	 * @param room the room
	 */
	public void addRoom(RoomModel room){
		hotel.addRoom(room);
	}
	
	/**
	 * Delete room.
	 *
	 * @param room the room
	 */
	public void deleteRoom(int number){
		hotel.deleteRoom(number);
	}
	
	/**
	 * Delete guest from room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(String name){
		hotel.deleteGuestFromRoom(name);
	}
	
	/**
	 * Delete all guests from room.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestsFromRoom(int number){
		hotel.deleteAllGuestFromRoom(number);
	}
	
	/**
	 * Adds the guest in room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void addGuestInRoom( int number, String name){
		hotel.addGuestInRoom(number, name);
	}
	
	public void changeCoast(int number, int coast)
	{
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
		{
			if(number == hotel.getRoom().getListOfNumbers().get(i).getNumber()){
				hotel.getRoom().getListOfNumbers().get(i).setCoast(coast);
			}
		}
	}
	
	public void changeStatusRepair(){
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++){
			if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == false){
				hotel.getRoom().getListOfNumbers().get(i).setOnRepair(true);
			} else if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == true){
				hotel.getRoom().getListOfNumbers().get(i).setOnRepair(false);
			}
		}
	}
	
	/**
	 * Sort by coast free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCoastComparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Sort by copasity free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCopasityComparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Sort by stars free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomStarsComparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Sort by coast room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCoastComparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Sort by copasity room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCopasityComparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Sort by stars room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomStarsCmparator());
		return hotel.getRoom().getListOfNumbers();
	}
	
	/**
	 * Show free rooms.
	 *
	 * @return the int
	 */
	public int showFreeRooms(){
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
			if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == false){
				t += 1;
			}
				
		return t;
	}
	
	/**
	 * Show chek out date.
	 *
	 * @param date the date
	 * @return the list
	 */
	public List<RoomModel> showChekOutDate(Date date){
		List<RoomModel> list = new ArrayList<RoomModel>();
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
		{
				for(int j = 0; j < hotel.getRoom().getListOfNumbers().get(i).getGuests().size(); j++)
				{
					if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == true && sdf.format(hotel.getRoom().getListOfNumbers().get(i).getGuests().get(j).getDateOfEvi()).equals(sdf.format(date))){
						list.add(hotel.getRoom().getListOfNumbers().get(i));
					}
				}
		}
		return list;
	}
	
	/**
	 * Show room details.
	 *
	 * @param room the room
	 * @return the string
	 */
	public String showRoomDetails(int number){
		String str = "";
		for(RoomModel roomMod: hotel.getRoom().getListOfNumbers()){
			if(number == roomMod.getNumber()){
				str = roomMod.toString();
			}
		}
		return str;
	}
	
	/**
	 * Show price per room.
	 *
	 * @param guest the guest
	 * @return the string
	 */
	public String showPricePerRoom(String name){
		String str = "Guest " + name  + " must pay ";
		for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
			for(GuestModel guestMod : roomMod.getGuests()){
				if(name.equals(guestMod.getName())){
					long diff = guestMod.getDateOfEvi().getTime() - guestMod.getDateOfAdd().getTime();
					str = str + (diff / (1000L*60L*60L*24L)*roomMod.getCoast()) + "$";
				}
			}
		}
		return str;
	}
	
	/**
	 * Show last three guests.
	 *
	 * @param room the room
	 * @return the string
	 */
	
	public String showLastThreeGuests(int number){
		reader.setProperties();
		int numberOfGuest = reader.getUtil().getRecordNumber();
		String str ="";
		for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
			if(number == roomMod.getNumber()){
				if(roomMod.getGuests().size() == numberOfGuest){
					for(int i = roomMod.getGuests().size()-numberOfGuest; i < roomMod.getGuests().size(); i++){
						str = str + roomMod.getGuests().get(i).getName() +" : "+ sdf.format(roomMod.getGuests().get(i).getDateOfEvi()) + "\n";
					}
				} else if(roomMod.getGuests().size() < 3){
					for(int i = 0; i < roomMod.getGuests().size(); i++){
						str = str + roomMod.getGuests().get(i).getName() +" : "+ sdf.format(roomMod.getGuests().get(i).getDateOfEvi()) + "\n";
					}
				}
			}
		}
		return str;
	}
	
	public void cloneRoom(int number) throws CloneNotSupportedException{
		hotel.cloneRoom(number);
	}
	
}
