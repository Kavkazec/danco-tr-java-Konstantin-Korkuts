package com.danco.training.view.action;


import com.danco.training.controller.HotelController;

public class AddGuestAction implements IAction {

	@Override
	public void execute() {
		HotelController.getInstance().addGuest();
	}

}
