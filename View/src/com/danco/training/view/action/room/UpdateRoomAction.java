package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InRoom;

public class UpdateRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteRoomAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {

			Object[] args = {InRoom.inputRoomWithID()};
			String methodName = "updateRoom";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}


}
