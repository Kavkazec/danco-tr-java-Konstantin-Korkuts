package com.danco.training.view.action;


import com.danco.training.controller.HotelController;
import com.danco.training.view.utils.InputGuest;

public class AddGuestAction implements IAction {

	@Override
	public void execute() {
		HotelController.getInstance().addGuest(InputGuest.inputGuest());
	}

}
