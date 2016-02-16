package com.danco.training.view.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InGuest;

public class AddGuestAction implements IAction {
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {InGuest.inputGuest()};
			String methodName = "addGuest";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			Logger logger = Logger.getLogger(AddGuestAction.class);
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
	}
	
	
}
