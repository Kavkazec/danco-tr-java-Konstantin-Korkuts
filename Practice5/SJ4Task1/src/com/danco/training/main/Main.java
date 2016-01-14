package com.danco.training.main;



import java.text.ParseException;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.danco.training.TextFileWorker;
import com.danco.training.logger.Config;
import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.parser.TextParser;
import com.danco.training.service.GuestService;
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
	 * @param args the arguments
	 * @throws ParseException 
	 */
	private static String LOG_PROPERTIES_FILE = "./src/log4j.properties";
	private static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) throws ParseException {
		
		Config config = new Config(LOG_PROPERTIES_FILE);
		config.init();
		
		Hotel hotel = Hotel.getInstance();
		
		RoomModel r1 = new RoomModel(1, 3, 5, 320);
		RoomModel r2 = new RoomModel(2, 1, 4, 200);
		RoomModel r3 = new RoomModel(3, 2, 3, 230);
		RoomModel r4 = new RoomModel(4, 4, 4, 330);
		RoomModel r5 = new RoomModel(5, 5, 2, 200);
		
		GuestModel g1 = new GuestModel(1, "Oksana",new GregorianCalendar(2015,11,25), new GregorianCalendar(2015,11,31));
		GuestModel g2 = new GuestModel(2, "Kostya",new GregorianCalendar(2015,11,27), new GregorianCalendar(2015,11,30));
		GuestModel g3 = new GuestModel(3, "Misha",new GregorianCalendar(2015,11,26), new GregorianCalendar(2015,11,30));
		GuestModel g4 = new GuestModel(4, "Serghei",new GregorianCalendar(2015,11,28), new GregorianCalendar(2015,11,29));
		GuestModel g5 = new GuestModel(5, "Pasha",new GregorianCalendar(2015,11,29), new GregorianCalendar(2015,11,30));
		GuestModel g6 = new GuestModel(6, "Andrei",new GregorianCalendar(2015,11,26), new GregorianCalendar(2015,11,27));

		ServiceModel s1 = new ServiceModel("champagne in the room", 40, new GregorianCalendar(2015,11,25));
		ServiceModel s2 = new ServiceModel("ded moroz in the room", 30, new GregorianCalendar(2015,11,27));
		ServiceModel s3 = new ServiceModel("snegurka in the room", 20, new GregorianCalendar(2015,11,26));
		
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
		
		hotel.addGuestInRoom(g2,r2);
		hotel.addGuestInRoom(g1,r3);
		hotel.addGuestInRoom(g3,r3);
		hotel.addGuestInRoom(g4,r1);
		hotel.addGuestInRoom(g5,r1);
		hotel.addGuestInRoom(g6,r1);
		
		hotel.addServiceToGuest(s1, g1);
		hotel.addServiceToGuest(s2, g1);
		hotel.addServiceToGuest(s3, g1);
		
		
		
		r2.setCoast(400);
		
		RoomService rs = new RoomService();
		GuestService gs = new GuestService();
		ServiceService ss = new ServiceService();
		
		System.out.println(rs.showFreeRooms());
		System.out.println(gs.showAllGuests());
		System.out.println();
		System.out.println(rs.showLastThreeGuests(r1));
		System.out.println();
		
		for(int i = 0; i < rs.showChekOutDate(new GregorianCalendar(2015,11,31).getTime()).size(); i++)
			System.out.println(rs.showChekOutDate(new GregorianCalendar(2015,11,31).getTime()).get(i).toString());
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
		
		logger.error(rs);
		
	}

}
