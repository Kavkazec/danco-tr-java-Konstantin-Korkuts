package com.danco.training.view.action.room;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.RoomModel;
import com.danco.training.transmission.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;
import com.danco.training.view.util.PrintRoom;

public class ShowChekOutDateAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(ShowChekOutDateAction.class);
	@Override
	public Transmission sendCommand() {
		Transmission trans = null;
		try {
			InReader.print("Enter date:");
			Object[] args = {InReader.readInt()};
			String methodName = "showChekOutDate";
			trans = new Transmission(methodName, args);

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return trans;
	}

	@Override
	public void answer(Object answerFromServer) {
		if (answerFromServer instanceof List<?>) {
			PrintRoom.printRooms((List<RoomModel>) answerFromServer);
		}
	}

}
