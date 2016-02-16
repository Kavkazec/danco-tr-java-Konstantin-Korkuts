package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.RoomModel;
import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.PrintRoom;

public class PrintRoomAction implements IAction{
	private final Logger logger = Logger.getLogger(PrintRoomAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "printRoom";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof List<?>) {
			PrintRoom.printRooms((List<RoomModel>) answerFromServer);
		}
	}

	
}
