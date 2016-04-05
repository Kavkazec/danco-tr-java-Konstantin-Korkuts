package com.danco.training.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;

public class ShowNumberOfFreeRoomsAction implements IAction {
	private final Logger LOGGER = Logger.getLogger(ShowNumberOfFreeRoomsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "numberOfFreeRooms";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof Integer && answerFromServer != null) {
			InReader.print(answerFromServer + "");
		}
	}

}
