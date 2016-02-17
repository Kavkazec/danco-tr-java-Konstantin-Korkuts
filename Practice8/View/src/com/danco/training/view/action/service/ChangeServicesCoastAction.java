package com.danco.training.view.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ChangeServicesCoastAction implements IAction{
	private final Logger logger = Logger.getLogger(ChangeServicesCoastAction.class);
	private static final String INPUT_NAME = "Enter name:";
	private static final String INPUT_COAST = "Enter coast:";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print(INPUT_NAME);
			InReader.print(INPUT_COAST);
			Object[] args = {InReader.readStrin(), InReader.readInt()};
			String methodName = "changeServicesCoast";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}

}
