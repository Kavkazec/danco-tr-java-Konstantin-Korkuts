package com.danco.training.view.action.guest;

import com.danco.training.server.Transmission;
import com.danco.training.view.action.IAction;
import com.danco.training.view.util.InReader;

public class PrintGuestsAction implements IAction{

	@Override
	public Transmission sendCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void answer(Object answerFromServer) {
		InReader.print("asgasdgas");
	}

}
