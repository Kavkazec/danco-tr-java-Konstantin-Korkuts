package com.danco.training.menu;

import com.danco.training.action.IAction;
import com.danco.training.transmission.Transmission;

public class MenuItem {
	private IAction action;
	private String title;
	private Menu nextMenu;

	public MenuItem(IAction action, String title, Menu nextMenu) {
		this.action = action;
		this.title = title;
		this.nextMenu = nextMenu;
	}

	public MenuItem(String title, Menu nextMenu) {
		this.title = title;
		this.nextMenu = nextMenu;
	}

	public Transmission sendCommand() {
		return action.sendCommand();
	}

	public void receiveAnswer(Object obj) {
		action.answer(obj);
	}

	public String getTitle() {
		return title;
	}

	public Menu getMenu() {
		return nextMenu;
	}

	public IAction getAction() {
		return action;

	}
}
