package com.danco.training.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InGuest;

public class UpdateGuestAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteGuestAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {InGuest.inputGuestWithID()};
			String methodName = "updateGuest";
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
