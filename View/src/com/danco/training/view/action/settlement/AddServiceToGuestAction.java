package com.danco.training.view.action.settlement;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.action.service.AddServiceAction;
import com.danco.training.view.util.InSettlement;

public class AddServiceToGuestAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(AddServiceAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {InSettlement.inputValuesForAdding()};
			String methodName = "addServiceToGuest";
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
