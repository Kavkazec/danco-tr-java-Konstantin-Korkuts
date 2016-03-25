package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.controller.HotelController;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class ChangeRoomsCoastAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ChangeRoomsCoastAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter room identifier:");
			Object[] args = {HotelController.getInstance().getByIdRoom(InReader.readInt())};
			String methodName = "changeRoomCoast";
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
