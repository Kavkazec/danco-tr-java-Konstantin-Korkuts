package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.RoomModel;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintRoom;

public class SortByStarsRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(SortByStarsRoomAction.class);
	private static final String DETAILS_ROOM = "number ; capacity ; stats ; coast ; free? ; on repair?";

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "sortByStarsRoom";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}
	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_ROOM);
		if (answerFromServer instanceof List && answerFromServer != null) {
			PrintRoom.printRooms((List<RoomModel>) answerFromServer);
		}
	}

}
