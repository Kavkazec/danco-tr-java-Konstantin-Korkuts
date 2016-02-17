package com.danco.training.view.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InGuest;

public class AddGuestAction implements IAction {
	private final Logger LOGGER = Logger.getLogger(AddGuestAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {InGuest.inputGuest()};
			String methodName = "addGuest";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
	}
	
	
}
