package com.danco.training.view.menu;

import com.danco.training.properties.PropertiesReader;
import com.danco.training.view.action.guest.AddGuestAction;
import com.danco.training.view.action.guest.AddServiceToGuestAction;
import com.danco.training.view.action.guest.BuildGuestsFromAnnotAction;
import com.danco.training.view.action.guest.DeleteGuestAction;
import com.danco.training.view.action.guest.ExportGuestAction;
import com.danco.training.view.action.guest.ImportGuestsAction;
import com.danco.training.view.action.guest.PrintGuestsAction;
import com.danco.training.view.action.guest.ShowGuestsServicesSortedByCoastAction;
import com.danco.training.view.action.guest.ShowGuestsServicesSortedByDateAction;
import com.danco.training.view.action.guest.ShowNumberOfGuestsAction;
import com.danco.training.view.action.guest.SortByDateGuestsAction;
import com.danco.training.view.action.guest.SortByNameGuestsAction;
import com.danco.training.view.action.room.AddGuestInRoomAction;
import com.danco.training.view.action.room.AddRoomAction;
import com.danco.training.view.action.room.BuildRoomsFromAnnotAction;
import com.danco.training.view.action.room.ChangeRoomsCoastAction;
import com.danco.training.view.action.room.ChangeRoomsStatusRepairAction;
import com.danco.training.view.action.room.CloneRoomAction;
import com.danco.training.view.action.room.DeleteAllGuestsFromRoomAction;
import com.danco.training.view.action.room.DeleteGuestFromRoomAction;
import com.danco.training.view.action.room.DeleteRoomAction;
import com.danco.training.view.action.room.ExportRoomsAction;
import com.danco.training.view.action.room.ImportRoomsAction;
import com.danco.training.view.action.room.PrintRoomAction;
import com.danco.training.view.action.room.ShowChekOutDateAction;
import com.danco.training.view.action.room.ShowLastThreeGuestsAction;
import com.danco.training.view.action.room.ShowNumberOfFreeRoomsAction;
import com.danco.training.view.action.room.ShowPricePerRoomAction;
import com.danco.training.view.action.room.ShowRoomDetailsAction;
import com.danco.training.view.action.room.SortByCoastFreeRoomAction;
import com.danco.training.view.action.room.SortByCoastRoomAction;
import com.danco.training.view.action.room.SortByCapacityFreeRoomAction;
import com.danco.training.view.action.room.SortByCapacityRoomAction;
import com.danco.training.view.action.room.SortByStarsFreeRoomAction;
import com.danco.training.view.action.room.SortByStarsRoomAction;
import com.danco.training.view.action.service.AddServiceAction;
import com.danco.training.view.action.service.BuildServicesFromAnnotAction;
import com.danco.training.view.action.service.ChangeServicesCoastAction;
import com.danco.training.view.action.service.DeleteServiceAction;
import com.danco.training.view.action.service.ExportServicesAction;
import com.danco.training.view.action.service.ImportServicesAction;
import com.danco.training.view.action.service.PrintServiceAction;

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
		PropertiesReader.getInstance().setProperties();
		mainMenu.addMenuItem(new MenuItem(null, "0 -> Open operations with guests ", guestMenu));
		mainMenu.addMenuItem(new MenuItem(null, "1 -> Open operations with rooms ", roomMenu));
		mainMenu.addMenuItem(new MenuItem(null, "2 -> Open operations with services", serviceMenu));
		mainMenu.addMenuItem(new MenuItem(null, "3 -> Exit ", null));
		
		guestMenu.addMenuItem(new MenuItem(new AddGuestAction(),"0 -> Add guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new DeleteGuestAction(),"1 -> Delete guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new PrintGuestsAction(),"2 -> Print guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"3 -> Other",guestMenuOther));
		guestMenu.addMenuItem(new MenuItem(new ExportGuestAction(),"4 -> Export guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new ImportGuestsAction(),"5 -> Import guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"6 -> Back", mainMenu));
		
		guestMenuOther.addMenuItem(new MenuItem(new AddServiceToGuestAction(),"0-> Add service to guest", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(new ShowNumberOfGuestsAction(),"1-> Show number of guests", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(new BuildGuestsFromAnnotAction(),"2-> Add guests from annotation", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(null,"3-> Sorting", guestMenuOtherSort));
		guestMenuOther.addMenuItem(new MenuItem(null,"4-> Back", guestMenu));
		
		guestMenuOtherSort.addMenuItem(new MenuItem(new SortByNameGuestsAction(),"0-> Sorting guests by name", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new SortByDateGuestsAction(),"1-> Sorting guests by date of arrival", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new ShowGuestsServicesSortedByCoastAction(),"2-> Sorting guest's services by coast", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(new ShowGuestsServicesSortedByDateAction(),"3-> Sorting guest's services by date of added", guestMenuOtherSort));
		guestMenuOtherSort.addMenuItem(new MenuItem(null,"4-> Back", guestMenuOther));
		
		roomMenu.addMenuItem(new MenuItem(new AddRoomAction(), "0 -> Add room", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new DeleteRoomAction(), "1 -> Delete rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new PrintRoomAction(), "2 -> Print rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "3 -> Other", roomMenuOther));
		roomMenu.addMenuItem(new MenuItem(new ExportRoomsAction(), "4 -> Export rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new ImportRoomsAction(), "5 -> Import rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "6 -> Back", mainMenu));
		
		roomMenuOther.addMenuItem(new MenuItem(new AddGuestInRoomAction(), "0-> Add guest in room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsCoastAction(), "1-> Change room's coast", roomMenuOther));
		if(!PropertiesReader.getInstance().getUtil().isSwitchOff()){
			roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsStatusRepairAction(), "2-> Change room's status", roomMenuOther));
		} else {
			roomMenuOther.addMenuItem(new MenuItem(null, "2-> Room's status cannot be changed!", roomMenuOther));
		}
		roomMenuOther.addMenuItem(new MenuItem(new DeleteGuestFromRoomAction(), "3-> Delete guest from room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new DeleteAllGuestsFromRoomAction(), "4-> Delete all guest from room", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(new BuildRoomsFromAnnotAction(), "5-> Add rooms from annotation", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(null, "6-> Show ...", roomMenuOtherShow));
		roomMenuOther.addMenuItem(new MenuItem(null, "7-> Sorting ...", roomMenuOtherSort));
		roomMenuOther.addMenuItem(new MenuItem(new CloneRoomAction(), "8-> Cloning", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(null, "9-> Back", roomMenu));
		
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
		serviceMenu.addMenuItem(new MenuItem(new ExportServicesAction(), "4 -> Export services", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(new ImportServicesAction(), "5 -> Import services", serviceMenu));
		serviceMenu.addMenuItem(new MenuItem(null, "6 -> Back", mainMenu));
		
		serviceMenuOther.addMenuItem(new MenuItem(new ChangeServicesCoastAction(), "0-> Change service's coast", serviceMenuOther));
		serviceMenuOther.addMenuItem(new MenuItem(new BuildServicesFromAnnotAction(), "1-> Add services from annotation", serviceMenuOther));
		serviceMenuOther.addMenuItem(new MenuItem(null, "2-> Back", serviceMenu));
	}
	
	public Menu getFirstMenu(){
		return mainMenu;
	}
}
