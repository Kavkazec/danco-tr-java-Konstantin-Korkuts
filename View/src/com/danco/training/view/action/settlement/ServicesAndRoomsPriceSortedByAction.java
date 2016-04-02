package com.danco.training.view.action.settlement;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.action.service.PrintServiceAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintString;

public class ServicesAndRoomsPriceSortedByAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintServiceAction.class);
	private static final String DETAILS_SERVICE = "coast-type";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Sort services and rooms by: choose -> ('type' or 'coast')");
			Object[] args = {InReader.readStrin()};
			String methodName = "servicesAndRoomsPriceSortedBy";
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