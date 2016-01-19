package com.danco.training.view.menu;

import com.danco.training.view.action.AddGuestAction;
import com.danco.training.view.action.AddRoomAction;
import com.danco.training.view.action.AddServiceAction;
import com.danco.training.view.action.PrintGuestsAction;
import com.danco.training.view.action.PrintRoomAction;
import com.danco.training.view.action.PrintServiceAction;
import com.danco.training.view.action.ShowNumberOfFreeRoomsAction;

public class Builder {
	private static Menu mainMenu = new Menu();
	private static Menu guestMenu = new Menu();
	private static Menu roomMenu = new Menu();
	private static Menu serviceMenu = new Menu();
	
	
	public static void buildMenu() {
		mainMenu.addMenuItem(new MenuItem(null, "0 -> Open operations with guests ", guestMenu));
		mainMenu.addMenuItem(new MenuItem(null, "1 -> Open operations with rooms ", roomMenu));
		mainMenu.addMenuItem(new MenuItem(null, "2 -> Open operations with services", serviceMenu));
		mainMenu.addMenuItem(new MenuItem(null, "3 - Exit ", null));
		
		guestMenu.addMenuItem(new MenuItem(new AddGuestAction(),"Press 0 - Add guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new PrintGuestsAction(),"Press 1 - Print guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"Press 9 - Back", mainMenu));
		
		roomMenu.addMenuItem(new MenuItem(new AddRoomAction(), "Press 0 - Add room", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new ShowNumberOfFreeRoomsAction(), "Press 1 - Show number of free rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new PrintRoomAction(), "Press 2 - Print rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "Press 9 - Back", mainMenu));
		
		serviceMenu.addMenuItem(new MenuItem(new AddServiceAction(), "Press 0 - Add service", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(new PrintServiceAction(), "Press 1 - Add service", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(null, "Press 9 - Back", mainMenu));
	}
	
	public static Menu getFirstMenu(){
		return mainMenu;
	}
}
