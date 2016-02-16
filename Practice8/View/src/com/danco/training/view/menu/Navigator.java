package com.danco.training.view.menu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.danco.training.server.Transmission;
import com.danco.training.view.util.InReader;

public class Navigator {
	private static final String FINAL_LINE = "#################################";
	private Logger logger = Logger.getLogger(Logger.class);
	private Menu currentMenu = new Menu();

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public boolean navigate(int index, ObjectInputStream in, ObjectOutputStream out) {
		if (this.currentMenu != null) {
			if ((index < currentMenu.getMenuItems().size()) && (index >= 0)) {
				try {
					if (this.currentMenu.getMenuItem(index).getAction() != null) {
						out.writeObject((this.currentMenu.getMenuItem(index).sendCommand()));
						out.flush();
						if (in.readObject() != null) {
							this.currentMenu.getMenuItem(index).receiveAnswer(in.readObject());
						}

					}
					if ((this.currentMenu.getMenuItem(index).getAction() != null)
							&& (this.currentMenu.getMenuItem(index).getMenu() == null)) {
						out.writeObject(new Transmission("Exit", null));
					}

				} catch (IOException | ClassNotFoundException e) {
					logger.error(e.getMessage(), e);
				}
				setCurrentMenu(this.currentMenu.getMenuItem(index).getMenu());
			} else {
				setCurrentMenu(null);
			}
			return true;
		}

		else {
			try {
				out.writeObject(new Transmission("Exit", null));
				this.currentMenu.getMenuItem(index).receiveAnswer(in.readObject());
			} catch (IOException | ClassNotFoundException e) {
				
				logger.error(e.getMessage(), e);
			}
			return false;
		}
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(currentMenu.getTitle() + System.lineSeparator());
		for (MenuItem mi : currentMenu.getMenuItems()) {
			sb.append(mi.getTitle() + System.lineSeparator());
		}
		InReader.print(sb.toString());
		InReader.print(FINAL_LINE);
	}
}
