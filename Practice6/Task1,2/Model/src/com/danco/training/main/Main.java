package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.reader.Export;
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
		
		Export export = new Export();
		Hotel hotel = Hotel.getInstance();
		
		for(Object rm: export.readFromFile("export.csv")){
			if("ServiceModel".equals(rm.getClass().getSimpleName())){
				hotel.addService((ServiceModel) rm);
			} else if("GuestModel".equals(rm.getClass().getSimpleName())){
				hotel.addGuest((GuestModel) rm);
			} else if("RoomModel".equals(rm.getClass().getSimpleName())){
				hotel.addRoom((RoomModel) rm);
			}
			
			
		}
		
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
