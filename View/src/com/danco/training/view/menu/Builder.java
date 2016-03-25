package com.danco.training.view.menu;

import com.danco.training.properties.PropertiesReader;
import com.danco.training.view.action.guest.AddGuestAction;
import com.danco.training.view.action.guest.BuildGuestsFromAnnotAction;
import com.danco.training.view.action.guest.DeleteGuestAction;
import com.danco.training.view.action.guest.ExportGuestAction;
import com.danco.training.view.action.guest.ImportGuestsAction;
import com.danco.training.view.action.guest.PrintGuestsAction;
import com.danco.training.view.action.guest.ShowNumberOfGuestsAction;
import com.danco.training.view.action.guest.UpdateGuestAction;
import com.danco.training.view.action.room.AddRoomAction;
import com.danco.training.view.action.room.BuildRoomsFromAnnotAction;
import com.danco.training.view.action.room.ChangeRoomsCoastAction;
import com.danco.training.view.action.room.ChangeRoomsStatusRepairAction;
import com.danco.training.view.action.room.CloneRoomAction;
import com.danco.training.view.action.room.DeleteRoomAction;
import com.danco.training.view.action.room.ExportRoomsAction;
import com.danco.training.view.action.room.ImportRoomsAction;
import com.danco.training.view.action.room.PrintRoomAction;
import com.danco.training.view.action.room.ShowNumberOfFreeRoomsAction;
import com.danco.training.view.action.room.ShowRoomDetailsAction;
import com.danco.training.view.action.room.SortByCoastFreeRoomAction;
import com.danco.training.view.action.room.SortByCoastRoomAction;
import com.danco.training.view.action.room.SortByCapacityFreeRoomAction;
import com.danco.training.view.action.room.SortByCapacityRoomAction;
import com.danco.training.view.action.room.SortByStarsFreeRoomAction;
import com.danco.training.view.action.room.SortByStarsRoomAction;
import com.danco.training.view.action.room.UpdateRoomAction;
import com.danco.training.view.action.service.AddServiceAction;
import com.danco.training.view.action.service.BuildServicesFromAnnotAction;
import com.danco.training.view.action.service.ChangeServicesCoastAction;
import com.danco.training.view.action.service.DeleteServiceAction;
import com.danco.training.view.action.service.ExportServicesAction;
import com.danco.training.view.action.service.ImportServicesAction;
import com.danco.training.view.action.service.PrintServiceAction;
import com.danco.training.view.action.settlement.AddSettlementAction;
import com.danco.training.view.action.settlement.DeleteSettlementAction;
import com.danco.training.view.action.settlement.PrintSettelmentAction;
import com.danco.training.view.action.settlement.UpdateSettlementAction;

public class Builder {
	private Menu mainMenu = new Menu("Main menu");
	private Menu guestMenu = new Menu("Guest menu");
	private Menu roomMenu = new Menu("Room menu");
	private Menu settlementMenu = new Menu("Settlement menu");
	private Menu serviceMenu = new Menu("Service menu");
	private Menu guestMenuOther = new Menu("Guest menu->Other");
	private Menu roomMenuOther = new Menu("Room menu->Other");
	private Menu serviceMenuOther = new Menu("Service menu->Other");
	private Menu settlementMenuOther = new Menu("Settlement menu->Other");
	private Menu roomMenuOtherSort = new Menu("Room menu->Other->Sort");
	private Menu roomMenuOtherShow = new Menu("Room menu->Other->Show");
	
	public void buildMenu() {
		PropertiesReader.getInstance().setProperties();
		mainMenu.addMenuItem(new MenuItem(null, "0 -> Open operations with guests ", guestMenu));
		mainMenu.addMenuItem(new MenuItem(null, "1 -> Open operations with rooms ", roomMenu));
		mainMenu.addMenuItem(new MenuItem(null, "2 -> Open operations with services", serviceMenu));
		mainMenu.addMenuItem(new MenuItem(null, "3 -> Open operations with settelments", settlementMenu));
		mainMenu.addMenuItem(new MenuItem(null, "4 -> Exit ", null));
		
		guestMenu.addMenuItem(new MenuItem(new AddGuestAction(),"0 -> Add guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new DeleteGuestAction(),"1 -> Delete guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new UpdateGuestAction(),"2 -> Update guest",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new PrintGuestsAction(),"3 -> Print guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"4 -> Other",guestMenuOther));
		guestMenu.addMenuItem(new MenuItem(new ExportGuestAction(),"5 -> Export guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(new ImportGuestsAction(),"6 -> Import guests",guestMenu));
		guestMenu.addMenuItem(new MenuItem(null,"7 -> Back", mainMenu));
		
		guestMenuOther.addMenuItem(new MenuItem(new ShowNumberOfGuestsAction(),"0-> Show number of guests", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(new BuildGuestsFromAnnotAction(),"1-> Add guests from annotation", guestMenuOther));
		guestMenuOther.addMenuItem(new MenuItem(null,"2-> Back", guestMenu));
		
		roomMenu.addMenuItem(new MenuItem(new AddRoomAction(), "0 -> Add room", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new DeleteRoomAction(), "1 -> Delete rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new UpdateRoomAction(), "2 -> Update rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new PrintRoomAction(), "3 -> Print rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "4 -> Other", roomMenuOther));
		roomMenu.addMenuItem(new MenuItem(new ExportRoomsAction(), "5 -> Export rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(new ImportRoomsAction(), "6 -> Import rooms", roomMenu));
		roomMenu.addMenuItem(new MenuItem(null, "7 -> Back", mainMenu));
		
		roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsCoastAction(), "0-> Change room's coast", roomMenuOther));
		if(!PropertiesReader.getInstance().getUtil().isSwitchOff()){
			roomMenuOther.addMenuItem(new MenuItem(new ChangeRoomsStatusRepairAction(), "1-> Change room's status", roomMenuOther));
		} else {
			roomMenuOther.addMenuItem(new MenuItem(null, "1-> Room's status cannot be changed!", roomMenuOther));
		}
		roomMenuOther.addMenuItem(new MenuItem(new BuildRoomsFromAnnotAction(), "2-> Add rooms from annotation", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(null, "3-> Show ...", roomMenuOtherShow));
		roomMenuOther.addMenuItem(new MenuItem(null, "4-> Sorting ...", roomMenuOtherSort));
		roomMenuOther.addMenuItem(new MenuItem(new CloneRoomAction(), "5-> Cloning", roomMenuOther));
		roomMenuOther.addMenuItem(new MenuItem(null, "6-> Back", roomMenu));
		
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowNumberOfFreeRoomsAction(), "1-> Number of free rooms", roomMenuOtherShow));
		roomMenuOtherShow.addMenuItem(new MenuItem(new ShowRoomDetailsAction(), "2-> Room's datails", roomMenuOtherShow));
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
		
		settlementMenu.addMenuItem(new MenuItem(new AddSettlementAction(),"0 -> Add settlement",settlementMenu));
		settlementMenu.addMenuItem(new MenuItem(new DeleteSettlementAction(),"1 -> Delete settlement",settlementMenu));
		settlementMenu.addMenuItem(new MenuItem(new UpdateSettlementAction(),"2 -> Update settlement",settlementMenu));
		settlementMenu.addMenuItem(new MenuItem(new PrintSettelmentAction(),"3 -> Print settlement",settlementMenu));
		settlementMenu.addMenuItem(new MenuItem(null,"4 -> Other",settlementMenuOther));
		settlementMenu.addMenuItem(new MenuItem(null,"5 -> Back", mainMenu));
	}
	
	public Menu getFirstMenu(){
		return mainMenu;
	}
}
