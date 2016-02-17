package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ChangeRoomsCoastAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ChangeRoomsCoastAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter number:");
			InReader.print("Enter coast:");
			Object[] args = {InReader.readInt(), InReader.readInt()};
			String methodName = "changeRoomsCoast";
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
