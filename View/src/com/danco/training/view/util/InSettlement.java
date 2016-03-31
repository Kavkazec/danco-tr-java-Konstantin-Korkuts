package com.danco.training.view.util;

import java.util.Date;

import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public class InSettlement {
	private static final String DATE_OF_THE_ADDED_SERVICE = "Date of the added service";
	private static final String DATE_OF_DEPARTURE = "Date of departure:";
	private static final String DATE_OF_ARRIVE = "Date of arrive:";
	private static final String SERVICE_ID = "Service ID:";
	private static final String GUEST_ID = "Guest ID:";
	private static final String ROOM_ID = "Room ID:";
	private static final String ID2 = "ID:";

	public static Settlement inputService(){
		InReader.print(ROOM_ID);
		int roomID = InReader.readInt();
		InReader.print(GUEST_ID);
		int guestID = InReader.readInt();
		InReader.print(DATE_OF_ARRIVE);
		Date dateOfArrival = InReader.readDate();
		InReader.print(DATE_OF_DEPARTURE);
		Date dateOfDeparture = InReader.readDate();
		Room room = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(roomID);
		Guest guest = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdGuest(guestID);
		Settlement sm = new Settlement(room, guest, null, dateOfArrival, dateOfDeparture, null, false);
		return sm;
	}
	
	public static Settlement inputServiceWithID(){
		InReader.print(ID2);
		int id = InReader.readInt();
		InReader.print(ROOM_ID);
		int roomID = InReader.readInt();
		InReader.print(SERVICE_ID);
		int guestID = InReader.readInt();
		InReader.print(DATE_OF_ARRIVE);
		Date dateOfArrival = InReader.readDate();
		InReader.print(DATE_OF_DEPARTURE);
		Date dateOfDeparture = InReader.readDate();
		Room room = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(roomID);
		Guest guest = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdGuest(guestID);
		Settlement sm = new Settlement(room, guest, null, dateOfArrival, dateOfDeparture, null, false);
		return sm;
	}
	
	public static Settlement inputValuesForAdding(){
		InReader.print(ROOM_ID);
		int roomID = InReader.readInt();
		InReader.print(GUEST_ID);
		int guestID = InReader.readInt();
		InReader.print(GUEST_ID);
		int serviceID = InReader.readInt();
		InReader.print(DATE_OF_ARRIVE);
		Date dateOfArrival = InReader.readDate();
		InReader.print(DATE_OF_DEPARTURE);
		Date dateOfDeparture = InReader.readDate();
		InReader.print(DATE_OF_THE_ADDED_SERVICE);
		Date serviceDate = InReader.readDate();
		Room room = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(roomID);
		Guest guest = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdGuest(guestID);
		Service service =  ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdService(serviceID);
		Settlement sm = new Settlement(room, guest, service, dateOfArrival, dateOfDeparture, serviceDate, false);
		return sm;
	}
}
