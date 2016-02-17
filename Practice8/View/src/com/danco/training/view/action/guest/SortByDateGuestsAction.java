package com.danco.training.view.action.guest;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.GuestModel;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintGuest;

public class SortByDateGuestsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(SortByDateGuestsAction.class);
	private static final String DETAILS_GUEST = "name ; date of added; date of departure ;";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "sortByDateGuests";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_GUEST);
		if (answerFromServer instanceof List && answerFromServer != null) {
			PrintGuest.printGuests((List<GuestModel>) answerFromServer);;
		}
	}
}
