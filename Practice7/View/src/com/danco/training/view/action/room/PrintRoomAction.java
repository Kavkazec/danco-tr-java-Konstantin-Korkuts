package com.danco.training.view.action.room;

import com.danco.training.controller.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.view.action.IAction;

public class PrintRoomAction implements IAction{

	private IHotelController hotel  = (IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class);

	@Override
	public void execute() {
		hotel.printRoom();
	}
	
}
