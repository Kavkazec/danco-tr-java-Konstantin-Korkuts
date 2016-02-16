package com.danco.training.view.action.service;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.RoomModel;
import com.danco.training.entity.ServiceModel;
import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.PrintRoom;
import com.danco.training.view.util.PrintService;

public class PrintServiceAction implements IAction{
	private final Logger logger = Logger.getLogger(PrintServiceAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "printService";
			trans = new Transmission(methodName, args);
		} catch (InputMismatchException e) {
			logger.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof List) {
			PrintService.printServices((List<ServiceModel>) answerFromServer);
		}
	}

	
}
