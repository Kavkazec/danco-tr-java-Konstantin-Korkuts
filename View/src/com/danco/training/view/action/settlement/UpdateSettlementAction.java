package com.danco.training.view.action.settlement;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.action.service.DeleteServiceAction;
import com.danco.training.view.util.InRoom;

public class UpdateSettlementAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteServiceAction.class);

	@Override
	public Transmission sendCommand(){
		Transmission trans = null;
		try {
			Object[] args = {InRoom.inputRoomWithID()};
			String methodName = "update";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
	}
}
