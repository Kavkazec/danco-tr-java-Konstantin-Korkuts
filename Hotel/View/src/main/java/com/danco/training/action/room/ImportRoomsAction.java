package com.danco.training.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;

public class ImportRoomsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ImportRoomsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "importRooms";
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
