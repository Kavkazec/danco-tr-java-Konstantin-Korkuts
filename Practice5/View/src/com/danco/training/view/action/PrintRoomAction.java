package com.danco.training.view.action;

import com.danco.training.controller.HotelController;

public class PrintRoomAction implements IAction{

	@Override
	public void execute() {
		HotelController.getInstance().printRoom();
	}
	
}
