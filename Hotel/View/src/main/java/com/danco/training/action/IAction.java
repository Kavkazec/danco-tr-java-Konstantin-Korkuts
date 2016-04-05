package com.danco.training.action;

import com.danco.training.transmission.Transmission;

public interface IAction {
	public Transmission sendCommand();
	public void answer(Object answerFromServer);
}
