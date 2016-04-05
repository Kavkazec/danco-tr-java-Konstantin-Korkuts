package com.danco.training.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;

public class ShowRoomDetailsAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ShowRoomDetailsAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter room identifier:");
			Object[] args = {((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(InReader.readInt())};
			String methodName = "showRoomDetails";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
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
