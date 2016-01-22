package com.danco.training.view.action.room;

import com.danco.training.controller.HotelController;
import com.danco.training.view.action.IAction;

public class ChangeRoomsStatusRepairAction implements IAction{

	@Override
	public void execute() {
		HotelController.getInstance().changeRoomsStatusRepair();
	}

}
