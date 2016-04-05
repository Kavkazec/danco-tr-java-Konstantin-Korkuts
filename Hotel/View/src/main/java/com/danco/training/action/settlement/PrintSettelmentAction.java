package com.danco.training.action.settlement;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.action.service.PrintServiceAction;
import com.danco.training.entity.Settlement;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;
import com.danco.training.util.PrintSettlement;

public class PrintSettelmentAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(PrintServiceAction.class);
	private static final String DETAILS_SERVICE = "id; number; guest name; service name; date of arrive; date of departure";
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			Object[] args = {};
			String methodName = "getAll";
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
			PrintSettlement.printSettlement((List<Settlement>) answerFromServer);
		}
	}

}
