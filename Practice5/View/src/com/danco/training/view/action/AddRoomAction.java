package com.danco.training.view.action;

import com.danco.training.controller.HotelController;
import com.danco.training.view.utils.InputRoom;

public class AddRoomAction implements IAction{

	@Override
	public void execute() {
		HotelController.getInstance().addRoom(InputRoom.inputRoom());
	}

}
