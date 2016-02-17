package com.danco.training.view.action.service;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;

public class ImportServicesAction implements IAction{
	private final Logger logger = Logger.getLogger(ImportServicesAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "importServices";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e){
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
	}

}
