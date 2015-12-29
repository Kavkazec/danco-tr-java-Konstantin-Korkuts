package com.danco.training.Service;

import java.util.Collections;

import com.danco.training.Comparator.FreeRoomCoastComparator;
import com.danco.training.Comparator.FreeRoomCopasityComparator;
import com.danco.training.Comparator.FreeRoomStarsComparator;
import com.danco.training.Comparator.RoomCoastComparator;
import com.danco.training.Comparator.RoomCopasityComparator;
import com.danco.training.Comparator.RoomStarsCmparator;
import com.danco.training.Model.RoomModel;
import com.danco.training.Storage.Hotel;



public class RoomService {
	private Hotel hotel;
	public RoomService(){
		hotel = Hotel.getInstance();
	}
	public void sortByCoastFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCoastComparator());
	}
	public void sortByCopasityFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCopasityComparator());
	}
	public void sortByStarsFreeRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomStarsComparator());
	}
	public void sortByCoastRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCoastComparator());
	}
	public void sortByCopasityRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCopasityComparator());
	}
	public void sortByStarsRoom(){
		Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomStarsCmparator());
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(hotel.getRoom().getListOfNumbers().size()));
		sb.append(System.lineSeparator());
		for(RoomModel g:hotel.getRoom().getListOfNumbers()){
			g.toString();
			System.lineSeparator();
		}
		return sb.toString();
	}
	
}
