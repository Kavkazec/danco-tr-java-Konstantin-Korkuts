package com.danco.training.view.menu;

import com.danco.training.view.action.guest.AddGuestAction;
import com.danco.training.view.action.guest.AddServiceToGuestAction;
import com.danco.training.view.action.guest.DeleteGuestAction;
import com.danco.training.view.action.guest.PrintGuestsAction;
import com.danco.training.view.action.guest.ShowGuestsFromFileAction;
import com.danco.training.view.action.guest.ShowGuestsServicesSortedByCoastAction;
import com.danco.training.view.action.guest.ShowGuestsServicesSortedByDateAction;
import com.danco.training.view.action.guest.ShowNumberOfGuestsAction;
import com.danco.training.view.action.guest.SortByDateGuestsAction;
import com.danco.training.view.action.guest.SortByNameGuestsAction;
import com.danco.training.view.action.guest.WriteGuestAction;
import com.danco.training.view.action.room.AddGuestInRoomAction;
import com.danco.training.view.action.room.AddRoomAction;
import com.danco.training.view.action.room.ChangeRoomsCoastAction;
import com.danco.training.view.action.room.ChangeRoomsStatusRepairAction;
import com.danco.training.view.action.room.DeleteAllGuestsFromRoomAction;
import com.danco.training.view.action.room.DeleteGuestFromRoomAction;
import com.danco.training.view.action.room.DeleteRoomAction;
import com.danco.training.view.action.room.PrintRoomAction;
import com.danco.training.view.action.room.ShowChekOutDateAction;
import com.danco.training.view.action.room.ShowLastThreeGuestsAction;
import com.danco.training.view.action.room.ShowNumberOfFreeRoomsAction;
import com.danco.training.view.action.room.ShowPricePerRoomAction;
import com.danco.training.view.action.room.ShowRoomDetailsAction;
import com.danco.training.view.action.room.ShowRoomsFromFileAction;
import com.danco.training.view.action.room.SortByCoastFreeRoomAction;
import com.danco.training.view.action.room.SortByCoastRoomAction;
import com.danco.training.view.action.room.SortByCapacityFreeRoomAction;
import com.danco.training.view.action.room.SortByCapacityRoomAction;
import com.danco.training.view.action.room.SortByStarsFreeRoomAction;
import com.danco.training.view.action.room.SortByStarsRoomAction;
import com.danco.training.view.action.room.WriteRoomsAction;
import com.danco.training.view.action.service.AddServiceAction;
import com.danco.training.view.action.service.ChangeServicesCoastAction;
import com.danco.training.view.action.service.DeleteServiceAction;
import com.danco.training.view.action.service.PrintServiceAction;
import com.danco.training.view.action.service.ShowServicesFromFileAction;
import com.danco.training.view.action.service.WriteServicesAction;

public class Builder {
	private Menu mainMenu = new Menu("Main menu");
	private Menu guestMenu = new Menu("Guest menu");
	private Menu roomMenu = new Menu("Room menu");
	private Menu serviceMenu = new Menu("Service menu");
	private Menu guestMenuOther = new Menu("Guest menu->Other");
	private Menu roomMenuOther = new Menu("Room menu->Other");
	private Menu serviceMenuOther = new Menu("Service menu->Other");
	private Menu guestMenuOtherSort = new Menu("Guest menu->Other->Sort");
	private Menu roomMenuOtherSort = new Menu("Room menu->Other->Sort");
	private Menu roomMenuOtherShow = new Menu("Room menu->Other->Show");
	
	
	public void buildMenu() {
		mainMenu.addMenuItem(new MenuItem(null, "0 -> Open operations with guests ", guestMenu));
		mainMenu.addMenuItem(new MenuItem(null, "1 -> Open operations with rooms ", roomMenu));
		mainMenu.addMenuItem(new MenuItem(null, "2 -> Open operations with services", serviceMenu));
		mainMenu.addMenuItem(new MenuItem(null, "3 - Exit ", null));
		
		guestMenu.addMenuItem(new MenuItem(new AddGuestAction(),"0 -> Add guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new DeleteGuestAction(),"1 -> Delete guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new PrintGuestsAction(),"2 -> Print guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"3 -> Other",guestMenuOther));
		guestMenu.addMenuItem(new MenuItem(new WriteGuestAction(),"4 -> Write guests in file",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new ShowGuestsFromFileAction(),"5 -> Reader geuets from file",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"6 -> Back", mainMenu));
		
		guestMenuOther.addMenuItem(new MenuItem(new AddServiceToGuestAction(),"0-> Add service to guest", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(new ShowNumberOfGuestsAction(),"1-> Show number of guests", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(null,"2-> Sorting", guestMenuOtherSort));
		guestMenuOther.addMenuItem(new MenuItem(null,"3-> Back", guestMenu));
		
		guestMenuOtherSort.addMenuItem(new MenuItem(new SortByNameGuestsAction(),"0-> Sorting guests by name", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new SortByDateGuestsAction(),"1-> Sorting guests by date of arrival", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new ShowGuestsServicesSortedByCoastAction(),"2-> Sorting guest's services by coast", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new ShowGuestsServicesSortedByDateAction(),"3-> Sorting guest's services by date of added", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(null,"4-> Back", guestMenuOther));
		
		roomMenu.addMenuItem(new MenuItem(new AddRoomAction(), "0 -> Add room", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new DeleteRoomAction(), "1 -> Delete rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new PrintRoomAction(), "2 -> Print rooms", roomMenu));;
		roomMenu.addMenuItem(new MenuItem(null, "3 -> Other", roomMenuOther));
		roomMenu.addMenuItem(new MenuItem(new WriteRoomsAction(), "4 -> Write rooms in file", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new ShowRoomsFromFileAction(), "5 -> Reader rooms from file", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "6 -> Back", mainMenu));
		
		roomMenuOther.addMenuItem(new MenuItem(new AddGuestInRoomAction(), "0-> Add guest in room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsCoastAction(), "1-> Change room's coast", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsStatusRepairAction(), "2-> Change room's status", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new DeleteGuestFromRoomAction(), "3-> Delete guest from room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new DeleteAllGuestsFromRoomAction(), "4-> Delete all guest from room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(null, "5-> Show ...", roomMenuOtherShow));
		roomMenuOther.addMenuItem(new MenuItem(null, "6-> Sorting ...", roomMenuOtherSort));
		roomMenuOther.addMenuItem(new MenuItem(null, "7-> Back", roomMenu));
		
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowChekOutDateAction(), "0-> Chek out date", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowLastThreeGuestsAction(), "1-> Last three guests", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowNumberOfFreeRoomsAction(), "2-> Number of free rooms", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowPricePerRoomAction(), "3-> Price per room", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowRoomDetailsAction(), "4-> Room's datails", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(null, "5-> Back", roomMenuOther));
		
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByCoastFreeRoomAction(), "0-> By coast free rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByCapacityFreeRoomAction(), "1-> By capacity free rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByStarsFreeRoomAction(), "2-> By number of stars free rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByCoastRoomAction(), "3-> By coast rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByCapacityRoomAction(), "4-> By capacity rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(new SortByStarsRoomAction(), "5-> By number of stars rooms", roomMenuOtherSort));
		roomMenuOtherSort.addMenuItem(new MenuItem(null, "6-> Back", roomMenuOther));
		
		serviceMenu.addMenuItem(new MenuItem(new AddServiceAction(), "0 -> Add service", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(new DeleteServiceAction(), "1 -> Delete service", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(new PrintServiceAction(), "2 -> Print services", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(null, "3 -> Other", serviceMenuOther));
		serviceMenu.addMenuItem(new MenuItem(new WriteServicesAction(), "4 -> Write services in file", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(new ShowServicesFromFileAction(), "5 -> Reader services from file", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(null, "6 -> Back", mainMenu));
		
		serviceMenuOther.addMenuItem(new MenuItem(new ChangeServicesCoastAction(), "0-> Change service's coast", serviceMenuOther));
		serviceMenuOther.addMenuItem(new MenuItem(null, "1-> Back", serviceMenu));
	}
	
	public Menu getFirstMenu(){
		return mainMenu;
	}
}
