package com.danco.training.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;

public class ExportServicesAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ExportServicesAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "exportServices";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e){
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}

}
