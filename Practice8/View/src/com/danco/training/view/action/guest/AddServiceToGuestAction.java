package com.danco.training.view.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class AddServiceToGuestAction implements IAction{
	private final Logger logger = Logger.getLogger(AddServiceToGuestAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter guest's name:");
			InReader.print("Enter service's name:");
			Object[] args = {InReader.readStrin(), InReader.readStrin()};
			String methodName = "addServiceToGuest";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			logger.error("Input mismatch!");
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}

}
