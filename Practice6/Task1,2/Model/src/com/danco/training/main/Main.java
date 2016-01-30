package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.storage.Hotel;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args) throws ParseException{
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Hotel hotel = Hotel.getInstance();
		
		
		
		for(int i = 0; i < hotel.getGuest().getGuests().size(); i++){
			System.out.println(hotel.getGuest().getGuests().get(i));
		}
		
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++){
			System.out.println(hotel.getRoom().getListOfNumbers().get(i));
		}
		for(int i = 0; i < hotel.getService().getListOfServices().size(); i++){
			System.out.println(hotel.getService().getListOfServices().get(i));
		}
	}

}
