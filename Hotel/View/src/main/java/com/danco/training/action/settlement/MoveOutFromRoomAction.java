package com.danco.training.action.settlement;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.danco.training.action.IAction;
import com.danco.training.action.service.DeleteServiceAction;
import com.danco.training.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.transmission.Transmission;
import com.danco.training.util.InReader;

public class MoveOutFromRoomAction implements IAction{
	private final Logger LOGGER = Logger.getLogger(DeleteServiceAction.class);
	private static final String INPUT1 = "Enter room identifier:";
	private static final String INPUT2 = "Enter guest identifier:";

	@Override
	public Transmission sendCommand(){
		Transmission trans = null;
		try {
			InReader.print(INPUT1);
			int roomId = InReader.readInt();
			Room room = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdRoom(roomId);
			InReader.print(INPUT2);
			int guestId = InReader.readInt();
			Guest guest = ((IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class)).getByIdGuest(guestId);
			Object[] args = {room, guest};
			String methodName = "moveOutFromRoom";
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
