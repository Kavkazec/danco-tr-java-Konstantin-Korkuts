package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Room;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintRoom;

public class SortByCapacityFreeRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(SortByCapacityFreeRoomAction.class);
	private static final String DETAILS_ROOM = "id ; number ; capacity ; stats ; coast ; free? ; on repair?";

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "sortByCapacityFreeRoom";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_ROOM);
		if (answerFromServer instanceof List<?>) {
			PrintRoom.printRooms((List<Room>) answerFromServer);
		}
	}
}
