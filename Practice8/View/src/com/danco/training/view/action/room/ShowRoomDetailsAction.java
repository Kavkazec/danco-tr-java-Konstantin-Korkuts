package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ShowRoomDetailsAction implements IAction{
	private final Logger logger = Logger.getLogger(ShowRoomDetailsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter number:");
			Object[] args = {InReader.readInt()};
			String methodName = "showRoomDetails";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof String) {
			InReader.print((String) answerFromServer);;
		}
	}

}
