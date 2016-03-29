package com.danco.training.view.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ChangeServicesCoastAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ChangeServicesCoastAction.class);
	private static final String INPUT_NAME = "Enter service identifier:";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print(INPUT_NAME);
			Object[] args = {((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdService(InReader.readInt())};
			String methodName = "changeServiceCoast";
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
