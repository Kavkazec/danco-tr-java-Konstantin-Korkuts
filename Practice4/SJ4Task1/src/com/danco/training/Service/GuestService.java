package com.danco.training.Service;

import java.util.Collections;

import com.danco.training.Comparator.GuestDateComparator;
import com.danco.training.Comparator.GuestNameComparator;
import com.danco.training.Model.GuestModel;
import com.danco.training.Storage.Hotel;


public class GuestService {
	private Hotel hotel;
	public GuestService(){
		hotel =  Hotel.getInstance();
	}
	public void sortByName(){
		Collections.sort(hotel.getGuest().getGuests(), new GuestNameComparator());
	}
	public void sortByDate(){
		Collections.sort(hotel.getGuest().getGuests(), new GuestDateComparator());
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(hotel.getGuest().getGuests().size()));
		sb.append(System.lineSeparator());
		for(GuestModel g:hotel.getGuest().getGuests()){
			g.toString();
			System.lineSeparator();
		}
		return sb.toString();
	}
}
