package com.danco.training.view.action.settlement;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.action.guest.PrintGuestsAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintGuest;

public class ShowLastThreeGuestAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintGuestsAction.class);
	private static final String DETAILS_GUEST = "id ; name ; date of added; date of departure ;";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter room id:");
			Object[] args = {((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(InReader.readInt())};
			String methodName = "showLastThreeGuest";
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
