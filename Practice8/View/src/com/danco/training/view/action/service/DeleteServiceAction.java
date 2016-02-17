package com.danco.training.view.action.service;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.ServiceModel;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintService;

public class DeleteServiceAction implements IAction{
	private final Logger logger = Logger.getLogger(DeleteServiceAction.class);
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String INPUT = "Enter name:";

	@Override
	public Transmission sendCommand(){
		Transmission trans = null;
		try {
			InReader.print(INPUT);
			Object[] args = {InReader.readStrin()};
			String methodName = "deleteService";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
	}

}
