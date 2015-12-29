package com.danco.training.Main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import com.danco.training.TextFileWorker;
import com.danco.training.Model.GuestModel;
import com.danco.training.Model.RoomModel;
import com.danco.training.Model.ServiceModel;
import com.danco.training.Parser.TextParser;
import com.danco.training.Storage.Hotel;

public class Main {

	public static void main(String[] args) {
		final String FILE_PATH_ROOMS = "src/files/rooms.txt";
		TextFileWorker tfw = new TextFileWorker(FILE_PATH_ROOMS);
		TextParser textParser = new TextParser(tfw);
		
		Hotel hotel = Hotel.getInstance();
		
		RoomModel r1 = new RoomModel(1, 2, 3, 100);
		RoomModel r2 = new RoomModel(2, 2, 4, 200);
		RoomModel r3 = new RoomModel(3, 2, 5, 300);
		
		GuestModel g1 = new GuestModel(1, "Kolya",new GregorianCalendar(), new GregorianCalendar(2015,11,31));
		GuestModel g2 = new GuestModel(2, "Kostya",new GregorianCalendar(), new GregorianCalendar(2015,11,31));
		GuestModel g3 = new GuestModel(3, "Misha",new GregorianCalendar(), new GregorianCalendar(2015,11,31));

		ServiceModel s1 = new ServiceModel("champagne in the room", 30, new GregorianCalendar());
		
		hotel.setGuest(g1);
		hotel.setGuest(g3);
		hotel.setGuest(g2);
		
		hotel.setRoom(r3);
		hotel.setRoom(r2);
		hotel.setRoom(r1);
		
		hotel.setService(s1);
		
		textParser.writeRoomsToFile();
		textParser.readRooms();
	}

}
