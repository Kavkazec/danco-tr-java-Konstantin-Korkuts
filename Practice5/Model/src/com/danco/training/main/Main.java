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
	public static void main(String[] args){
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		
		Hotel hotel = Hotel.getInstance();
		
		RoomModel r1 = new RoomModel(1, 3, 5, 320);
		RoomModel r2 = new RoomModel(2, 1, 4, 200);
		RoomModel r3 = new RoomModel(3, 2, 3, 230);
		RoomModel r4 = new RoomModel(4, 4, 4, 330);
		RoomModel r5 = new RoomModel(5, 5, 2, 200);
		
		GuestModel g1 = new GuestModel( "Oksana",new GregorianCalendar(2015,11,25), new GregorianCalendar(2015,11,31));
		GuestModel g2 = new GuestModel( "Kostya",new GregorianCalendar(2015,11,27), new GregorianCalendar(2015,11,30));
		GuestModel g3 = new GuestModel( "Misha",new GregorianCalendar(2015,11,26), new GregorianCalendar(2015,11,30));
		GuestModel g4 = new GuestModel( "Serghei",new GregorianCalendar(2015,11,28), new GregorianCalendar(2015,11,29));
		GuestModel g5 = new GuestModel( "Pasha",new GregorianCalendar(2015,11,29), new GregorianCalendar(2015,11,30));
		GuestModel g6 = new GuestModel( "Andrei",new GregorianCalendar(2015,11,26), new GregorianCalendar(2015,11,27));

		ServiceModel s1 = new ServiceModel("champagne in the room", 40);
		ServiceModel s2 = new ServiceModel("ded moroz in the room", 30);
		ServiceModel s3 = new ServiceModel("snegurka in the room", 20);
		
		hotel.addGuest(g1);
		hotel.addGuest(g2);
		hotel.addGuest(g3);
		hotel.addGuest(g4);
		hotel.addGuest(g5);
		hotel.addGuest(g6);
		
		
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		hotel.addRoom(r5);
		
		hotel.addService(s1);
		hotel.addService(s2);
		hotel.addService(s3);
		
		hotel.addGuestInRoom(r2,g2);
		hotel.addGuestInRoom(r3,g1);
		hotel.addGuestInRoom(r3,g3);
		hotel.addGuestInRoom(r1,g4);
		hotel.addGuestInRoom(r1,g5);
		hotel.addGuestInRoom(r1,g6);
		
		hotel.addServiceToGuest(g1, s1);
		hotel.addServiceToGuest(g1, s2);
		hotel.addServiceToGuest(g1, s3);
		
		r2.setCoast(400);
		
		hotel.updateGuest(g1, "17-01-2016",  "20-01-2016");
		
		hotel.writeGuests();
		hotel.writeRooms();
		hotel.writeServices();
		
		RoomService rs = new RoomService();
		GuestService gs = new GuestService();
		ServiceService ss = new ServiceService();
		HotelService hs = HotelService.getInstance();
		
		System.out.println(rs.showFreeRooms());
		System.out.println(gs.showAllGuests());
		System.out.println();
		System.out.println(rs.showLastThreeGuests(r1));
		System.out.println();
		
		try {
			for(int i = 0; i < rs.showChekOutDate(sdf.parse("20-01-2016")).size(); i++)
				System.out.println(rs.showChekOutDate(sdf.parse("20-01-2016")).get(i).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println(rs.showRoomDetails(r1));
		System.out.println(rs.showPricePerRoom(g2));
		System.out.println();
		
		for(ServiceModel sm : gs.showListOfServicesSortedByCoast(g1)){
			System.out.println(sm);
		}
		
		System.out.println();
		
		for(ServiceModel sm : gs.showListOfServicesSortedByDate(g1)){
			System.out.println(sm);
		}
		System.out.println();
		
		
		
		hotel.writeGuests();
		hotel.writeRooms();
		hotel.writeServices();
		
		System.out.print(hotel.showGuestsFromFile());
		System.out.println();
		System.out.print(hotel.showRoomsFromFile());
		System.out.println();
		System.out.print(hotel.showServicesFromFile());
		
		hs.hah();
		
		
		
	
	}

}
