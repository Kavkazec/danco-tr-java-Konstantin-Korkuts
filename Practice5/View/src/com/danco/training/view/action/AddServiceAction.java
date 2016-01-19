package com.danco.training.view.action;

import java.io.IOException;

import com.danco.training.controller.HotelController;
import com.danco.training.view.utils.InputService;

public class AddServiceAction implements IAction{

	@Override
	public void execute() {
		try {
			HotelController.getInstance().addService(InputService.inputService());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
