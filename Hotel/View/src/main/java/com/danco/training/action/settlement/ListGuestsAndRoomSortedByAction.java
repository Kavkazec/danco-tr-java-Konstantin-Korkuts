package com.danco.training.action.settlement;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.action.service.PrintServiceAction;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;
import com.danco.training.util.PrintString;

public class ListGuestsAndRoomSortedByAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintServiceAction.class);
	private static final String DETAILS_SERVICE = "guest id ; guest name; room id; room number; date of departure";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Sort guests and rooms by: choose -> ('name' or 'date')");
			Object[] args = {InReader.readStrin()};
			String methodName = "listGuestsAndRoomsSortedBy";
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