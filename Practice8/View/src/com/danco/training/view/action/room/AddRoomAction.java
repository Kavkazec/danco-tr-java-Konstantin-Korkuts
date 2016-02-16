package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InRoom;

public class AddRoomAction implements IAction{
	private final Logger logger = Logger.getLogger(AddRoomAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {InRoom.inputRoom()};
			String methodName = "addRoom";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
	}

}
