package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Room;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.PrintRoom;

public class SortByCoastFreeRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(SortByCoastFreeRoomAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "sortByCoastFreeRoom";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof List<?>) {
			PrintRoom.printRooms((List<Room>) answerFromServer);
		}
	}
}
