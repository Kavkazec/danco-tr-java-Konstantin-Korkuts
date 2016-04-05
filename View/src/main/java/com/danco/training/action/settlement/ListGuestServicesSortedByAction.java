package com.danco.training.action.settlement;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.action.service.PrintServiceAction;
import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;
import com.danco.training.util.PrintString;

public class ListGuestServicesSortedByAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintServiceAction.class);
	private static final String DETAILS_SERVICE = "service id ; service name; coast; date";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter guest id:");
			int id = InReader.readInt();
			InReader.print("Sort guest's services by: choose -> ('coast' or 'date')");
			Object[] args = {((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class))
					.getByIdGuest(id), InReader.readStrin()};
			String methodName = "listGuestServicesSortedByCoast";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_SERVICE);
		if (answerFromServer instanceof List && answerFromServer != null) {
			PrintString.printString((List<String>) answerFromServer);
		}
	}

}
