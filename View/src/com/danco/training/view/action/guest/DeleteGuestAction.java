package com.danco.training.view.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class DeleteGuestAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteGuestAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter name:");
			Object[] args = {InReader.readStrin()};
			String methodName = "deleteGuest";
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
