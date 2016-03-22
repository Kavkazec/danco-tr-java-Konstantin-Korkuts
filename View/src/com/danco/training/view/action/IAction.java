package com.danco.training.view.action;

import com.danco.training.transmission.Transmission;

public interface IAction {
	public Transmission sendCommand();
	public void answer(Object answerFromServer);
}
