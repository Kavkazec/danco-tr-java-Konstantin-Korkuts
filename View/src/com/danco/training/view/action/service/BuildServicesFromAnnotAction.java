package com.danco.training.view.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;

public class BuildServicesFromAnnotAction implements IAction {
	private final Logger LOGGER = Logger.getLogger(BuildServicesFromAnnotAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "buildServicesFromAnnot";
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
