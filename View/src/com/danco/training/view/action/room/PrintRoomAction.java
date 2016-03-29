package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Room;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintRoom;

public class PrintRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintRoomAction.class);
	private static final String DETAILS_GUEST = "id ; number; capacity; stars; isFree? ; OnRepair?";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "getRooms";
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
