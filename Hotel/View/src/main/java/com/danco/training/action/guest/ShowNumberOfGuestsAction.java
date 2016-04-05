package com.danco.training.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;

public class ShowNumberOfGuestsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ShowNumberOfGuestsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "numberOfGuests";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof Integer) {
			InReader.print(answerFromServer + "");
		}
	}
}
