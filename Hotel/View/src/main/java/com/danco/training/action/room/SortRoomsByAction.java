package com.danco.training.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.entity.Room;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;
import com.danco.training.util.PrintRoom;

public class SortRoomsByAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintRoomAction.class);
	private static final String DETAILS_GUEST = "id ; number; capacity; stars; isFree? ; OnRepair?";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Sort ('All' or 'Free') rooms by ('capacity' or 'coast' or 'numberOfStars')");
			Object[] args = {InReader.readStrin()};
			String methodName = "sortRoomsBy";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_GUEST);
		if (answerFromServer instanceof List<?>) {
			PrintRoom.printRooms((List<Room>) answerFromServer);
		}
	}

}
