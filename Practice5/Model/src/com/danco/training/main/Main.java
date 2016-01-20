package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.service.GuestService;
import com.danco.training.service.HotelService;
import com.danco.training.service.RoomService;
import com.danco.training.service.ServiceService;
import com.danco.training.storage.Hotel;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 */
	//private static String LOG_PROPERTIES_FILE = "./src/log4j.properties";
	
	/** The logger. */
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args) throws ParseException{
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		
		Hotel hotel = Hotel.getInstance();
		
		RoomModel r1 = new RoomModel(1, 3, 5, 320);
		RoomModel r2 = new RoomModel(2, 1, 4, 200);
		RoomModel r3 = new RoomModel(3, 2, 3, 230);
		RoomModel r4 = new RoomModel(4, 4, 4, 330);
		RoomModel r5 = new RoomModel(5, 5, 2, 200);
		
		GuestModel g1 = new GuestModel( "Oksana",sdf.parse("25-12-2015"), sdf.parse("31-12-2015"));
		GuestModel g2 = new GuestModel( "Kostya",sdf.parse("27-12-2015"), sdf.parse("30-12-2015"));
		GuestModel g3 = new GuestModel( "Misha",sdf.parse("26-12-2015"), sdf.parse("30-12-2015"));

		ServiceModel s1 = new ServiceModel("champagne in the room", 40);
		ServiceModel s2 = new ServiceModel("ded moroz in the room", 30);
		ServiceModel s3 = new ServiceModel("snegurka in the room", 20);
		
		hotel.addGuest(g1);
		hotel.addGuest(g2);
		hotel.addGuest(g3);
		
		
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		hotel.addRoom(r5);
		
		hotel.addService(s1);
		hotel.addService(s2);
		hotel.addService(s3);
		
		hotel.addGuestInRoom(2,"Kostya");
		hotel.addGuestInRoom(3,"Oksana");
		hotel.addGuestInRoom(1,"Misha");
		
		hotel.addServiceToGuest("Oksana", "champagne in the room");
		hotel.addServiceToGuest("Oksana", "ded moroz in the room");
		hotel.addServiceToGuest("Oksana", "snegurka in the room");
		
		
		for(int i = 0; i < hotel.getGuest().getGuests().size(); i++){
			System.out.println(hotel.getGuest().getGuests().get(i));
		}
		
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++){
			System.out.println(hotel.getRoom().getListOfNumbers().get(i));
		}
		
		
		for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++){
			for(int j = 0; j < hotel.getRoom().getListOfNumbers().get(i).getGuests().size(); j++)
			System.out.println(hotel.getRoom().getListOfNumbers().get(i).getGuests().get(j).toString());
		}
		HotelService hs = HotelService.getInstance();
		hs.deleteGuest("Misha");
		
		for(int i = 0; i < hotel.getGuest().getGuests().size(); i++){
			System.out.println(hotel.getGuest().getGuests().get(i));
		}
		
		hotel.writeGuests();
		hotel.writeServices();
		hotel.writeToFileRooms();

	}

}
