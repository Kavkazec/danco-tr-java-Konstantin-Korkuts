package com.danco.training.view.action.service;

import com.danco.training.controller.HotelController;
import com.danco.training.view.action.IAction;

public class AddServiceAction implements IAction{

	@Override
	public void execute() {
			HotelController.getInstance().addService();
	}
}