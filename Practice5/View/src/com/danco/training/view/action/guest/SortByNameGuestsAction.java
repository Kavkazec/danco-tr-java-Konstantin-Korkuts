package com.danco.training.view.action.guest;

import com.danco.training.controller.HotelController;
import com.danco.training.view.action.IAction;

public class SortByNameGuestsAction implements IAction{

	@Override
	public void execute() {
		HotelController.getInstance().sortByNameGuests();
	}

}
