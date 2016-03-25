package com.danco.training.view.action.settlement;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.controller.HotelController;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.action.service.DeleteServiceAction;
import com.danco.training.view.util.InReader;

public class DeleteSettlementAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteServiceAction.class);
	private static final String INPUT = "Enter settlement identifier:";

	@Override
	public Transmission sendCommand(){
		Transmission trans = null;
		try {
			InReader.print(INPUT);
			Object[] args = {HotelController.getInstance().getByIdSettlement(InReader.readInt())};
			String methodName = "delete";
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
