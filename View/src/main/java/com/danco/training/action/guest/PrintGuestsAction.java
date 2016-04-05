package com.danco.training.action.guest;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.entity.Guest;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;
import com.danco.training.util.PrintGuest;

public class PrintGuestsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintGuestsAction.class);
	private static final String DETAILS_GUEST = "id ; name ; date of added; date of departure ;";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "getGuests";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_GUEST);
		if (answerFromServer instanceof List && answerFromServer != null) {
			PrintGuest.printGuests((List<Guest>) answerFromServer);;
		}
	}
}
