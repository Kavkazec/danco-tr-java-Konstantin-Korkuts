package com.danco.training.view.action.guest;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InGuest;
import com.danco.training.view.util.InService;

public class AddServiceToGuestAction implements IAction{
	private InGuest guest;
	private InService service;
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			guest = new InGuest();
			service = new InService();
			
			Object[] args = {guest.inputGuest()};
			String methodName = "addGuest";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			Logger logger = Logger.getLogger(AddGuestAction.class);
			logger.error("Input mismatch!");
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		// TODO Auto-generated method stub
		
	}

}
