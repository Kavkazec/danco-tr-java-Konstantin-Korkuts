package com.danco.training.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.danco.training.Comparator.FreeRoomCoastComparator;
import com.danco.training.Comparator.FreeRoomCopasityComparator;
import com.danco.training.Comparator.FreeRoomStarsComparator;
import com.danco.training.Comparator.RoomCoastComparator;
import com.danco.training.Comparator.RoomCopasityComparator;
import com.danco.training.Comparator.RoomStarsCmparator;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Storage.Hotel;



// TODO: Auto-generated Javadoc
/**
 * The Class RoomService.
 */
public class RoomService {
	
	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel;
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Instantiates a new room service.
	 */
	public RoomService(){
		hotel = Hotel.getInstance();
	}
	
	/**
	 * Sort by coast free room.
	 */
	public void sortByCoastFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCoastComparator());
	}
	
	/**
	 * Sort by copasity free room.
	 */
	public void sortByCopasityFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCopasityComparator());
	}
	
	/**
	 * Sort by stars free room.
	 */
	public void sortByStarsFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomStarsComparator());
	}
	
	/**
	 * Sort by coast room.
	 */
	public void sortByCoastRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCoastComparator());
	}
	
	/**
	 * Sort by copasity room.
	 */
	public void sortByCopasityRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCopasityComparator());
	}
	
	/**
	 * Sort by stars room.
	 */
	public void sortByStarsRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomStarsCmparator());
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
	public String showRoomDetails(RoomModel room){
		String str = "";
		for(RoomModel roomMod: hotel.getRoom().getListOfNumbers()){
			if(roomMod.equals(room)){
				str = room.toString();
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
	public String showPricePerRoom(GuestModel guest){
		String str = "Guest " + guest.getName() + " with ID " + guest.getId() + " must pay ";
		for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
			for(GuestModel guestMod : roomMod.getGuests()){
				if(guestMod.equals(guest)){
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
	
	public String showLastThreeGuests(RoomModel room){
		String str ="";
		for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
			if(roomMod == room){
				for(int i = roomMod.getGuests().size()-3; i < roomMod.getGuests().size(); i++){
					str = str + roomMod.getGuests().get(i).getName() +" : "+ sdf.format(roomMod.getGuests().get(i).getDateOfEvi()) + "\n";
				}
			}
		}
		return str;
	}
	
}
