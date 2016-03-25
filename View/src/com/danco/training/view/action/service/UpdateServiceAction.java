package com.danco.training.view.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InService;

public class UpdateServiceAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteServiceAction.class);

	@Override
	public Transmission sendCommand(){
		Transmission trans = null;
		try {
			Object[] args = {InService.inputServiceWithID()};
			String methodName = "updateService";
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
