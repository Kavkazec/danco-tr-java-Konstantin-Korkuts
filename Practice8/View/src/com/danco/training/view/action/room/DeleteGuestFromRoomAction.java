package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class DeleteGuestFromRoomAction implements IAction{
	private final Logger logger = Logger.getLogger(DeleteGuestFromRoomAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter name:");
			Object[] args = {InReader.readStrin()};
			String methodName = "deleteGuestFromRoom";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}

}
