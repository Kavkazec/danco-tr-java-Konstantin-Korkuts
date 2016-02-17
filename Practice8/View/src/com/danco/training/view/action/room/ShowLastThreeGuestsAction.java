package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ShowLastThreeGuestsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ShowLastThreeGuestsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter number:");
			Object[] args = {InReader.readInt()};
			String methodName = "showLastThreeGuests";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof Integer) {
			InReader.print((Integer) answerFromServer + "");
		}
	}
}
