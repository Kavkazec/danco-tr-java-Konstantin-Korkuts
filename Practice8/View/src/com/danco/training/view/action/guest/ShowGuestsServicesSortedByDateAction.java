package com.danco.training.view.action.guest;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.ServiceModel;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintService;

public class ShowGuestsServicesSortedByDateAction implements IAction{
	private final Logger logger = Logger.getLogger(ShowGuestsServicesSortedByDateAction.class);
	private static final String DETAILS_S = "name ; coast";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter name:");
			Object[] args = {InReader.readStrin()};
			String methodName = "showGuestsServicesSortedByDate";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		InReader.print(DETAILS_S );
		if (answerFromServer instanceof List && answerFromServer != null) {
			PrintService.printServices((List<ServiceModel>) answerFromServer);;
		}
	}
}
