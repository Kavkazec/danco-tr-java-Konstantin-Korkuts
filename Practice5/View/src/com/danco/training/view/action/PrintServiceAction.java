package com.danco.training.view.action;

import com.danco.training.controller.HotelController;

public class PrintServiceAction implements IAction{

	@Override
	public void execute() {
		HotelController.getInstance().printService();
	}
	
}
