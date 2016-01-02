package com.danco.training.Main;



import java.util.GregorianCalendar;

import com.danco.training.TextFileWorker;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Model.ServiceModel;
import com.danco.training.Parser.TextParser;
import com.danco.training.Service.GuestService;
import com.danco.training.Service.RoomService;
import com.danco.training.Service.ServiceService;
import com.danco.training.Storage.Hotel;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final String FILE_PATH_ROOMS = "src/files/rooms.txt";
		final String FILE_PATH_GUESTS = "src/files/guests.txt";
		final String FILE_PATH_SERVICES = "src/files/services.txt";
		TextFileWorker tfw1 = new TextFileWorker(FILE_PATH_ROOMS);
		TextParser textParser1 = new TextParser(tfw1);
		TextFileWorker tfw2 = new TextFileWorker(FILE_PATH_GUESTS);
		TextParser textParser2 = new TextParser(tfw2);
		TextFileWorker tfw3 = new TextFileWorker(FILE_PATH_SERVICES);
		TextParser textParser3 = new TextParser(tfw3);
		
		 
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

		ServiceModel s1 = new ServiceModel("champagne in the room", 10, new GregorianCalendar(2015,11,25));
		ServiceModel s2 = new ServiceModel("ded moroz in the room", 30, new GregorianCalendar(2015,11,27));
		ServiceModel s3 = new ServiceModel("snegurka in the room", 20, new GregorianCalendar(2015,11,26));
		
		hotel.getGuest().addGuests(g1);
		hotel.getGuest().addGuests(g2);
		hotel.getGuest().addGuests(g3);
		hotel.getGuest().addGuests(g4);
		hotel.getGuest().addGuests(g5);
		hotel.getGuest().addGuests(g6);
		
		
		hotel.getRoom().addNumber(r1);
		hotel.getRoom().addNumber(r2);
		hotel.getRoom().addNumber(r3);
		hotel.getRoom().addNumber(r4);
		hotel.getRoom().addNumber(r5);
		
		hotel.getService().addService(s1);
		hotel.getService().addService(s2);
		hotel.getService().addService(s3);
		
		r2.setGuests(g2);
		r3.setGuests(g1);
		r3.setGuests(g3);
		r1.setGuests(g4);
		r1.setGuests(g5);
		r1.setGuests(g6);
		
		g1.setServices(s2);
		g1.setServices(s3);
		
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
		System.out.println(rs.showPricePerRoom(g1));
		System.out.println();
		
		for(ServiceModel sm : gs.showListOfServicesSortedByCoast(g1)){
			System.out.println(sm);
		}
		
		System.out.println();
		
		for(ServiceModel sm : gs.showListOfServicesSortedByDate(g1)){
			System.out.println(sm);
		}
		
		
		
		rs.sortByStarsFreeRoom();
		
		System.out.println();
		textParser1.writeRoomsToFile();
		textParser1.readRooms();
		
		System.out.println();
		textParser2.writeGuestsToFile();
		textParser2.readGuests();
		
		System.out.println();
		textParser3.writeServicesToFile();
		textParser3.readServices();
		
	}

}
