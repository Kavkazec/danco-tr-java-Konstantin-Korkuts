package com.danco.training.view.action.room;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class DeleteRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteRoomAction.class);

	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter room id:");
			Object[] args = {((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(InReader.readInt())};
			String methodName = "deleteRoom";
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
