package com.danco.training.controller;

import java.util.Date;
import java.util.List;

import com.danco.training.controller.api.IGuestService;
import com.danco.training.controller.api.IHotelController;
import com.danco.training.controller.api.IRoomService;
import com.danco.training.controller.api.IServiceService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.GuestModel;
import com.danco.training.entity.RoomModel;
import com.danco.training.entity.ServiceModel;

public class HotelController implements IHotelController {
	private RoomController roomCon;
	private GuestController guestCon;
	private ServiceController serviceCon;
	
	private static HotelController instance;
	
	public static HotelController getInstance(){
		if(instance == null){
			instance = new HotelController();
		}
		return instance;
	}
	
	public RoomController getRoomCon() {
		if(roomCon == null){
			roomCon = new RoomController((IRoomService) DependencyInjection.getInstance().getClassInstance(IRoomService.class));
		}
		return roomCon;
	}
	
	public GuestController getGuestCon() {
		if(guestCon == null){
			guestCon = new GuestController((IGuestService) DependencyInjection.getInstance().getClassInstance(IGuestService.class));
		}
		return guestCon;
	}
	
	public ServiceController getServiceCon() {
		if(serviceCon == null){
			serviceCon = new ServiceController((IServiceService) DependencyInjection.getInstance().getClassInstance(IServiceService.class));
		}
		return serviceCon;
	}
	
	public void addGuest(GuestModel guest){
		getGuestCon().addGuest(guest);
	}
	
	public void deleteGuest(String name){
		getGuestCon().deletGuest(name);
	}
	
	public List<GuestModel> sortByNameGuests(){
		return getGuestCon().sortByNameGuests();
	}
	
	public List<GuestModel> sortByDateGuests(){
		return getGuestCon().sortByDateGuests();
	}
	
	public int showNumberOfGuests(){
		return getGuestCon().showNumberOfGuests();
	}
	
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name){
		return getGuestCon().showGuestsServicesSortedByCoast(name);
	}
	
	public List<ServiceModel> showGuestsServicesSortedByDate(String name){
		return getGuestCon().showGuestsServicesSortedByDate(name);
	}
	
	public void addServiceToGuest(String nameGuest, String nameService){
		getGuestCon().addServiceToGuest(nameGuest, nameService);
	}
	
	public List<GuestModel> printGuest(){
		return getGuestCon().printGuest();
	}
	
	public void addRoom(RoomModel room){
		getRoomCon().addRoom(room);
	}
	
	public void deleteRoom(int number){
		getRoomCon().deleteRoom(number);
	}
	
	public void deleteGuestFromRoom(String name){
		getRoomCon().deleteGuestFromRoom(name);
	}
	
	public void deleteAllGuestsFromRoom(int number){
		getRoomCon().deleteAllGuestsFromRoom(number);
	}
	
	public void changeRoomsCoast(int number, int coast){
		getRoomCon().changeRoomsCoast(number, coast);
	}
	
	public void changeRoomsStatusRepair(){
		getRoomCon().changeRoomsStatusRepair();
	}
	
	public List<RoomModel> sortByCoastFreeRoom(){
		return getRoomCon().sortByCoastFreeRoom();
	}
	
	public List<RoomModel> sortByCopasityFreeRoom(){
		return getRoomCon().sortByCopasityFreeRoom();
	}
	
	public List<RoomModel> sortByStarsFreeRoom(){
		return getRoomCon().sortByStarsFreeRoom();
	}
	
	public List<RoomModel> sortByCoastRoom(){
		return getRoomCon().sortByCoastRoom();
	}
	
	public List<RoomModel> sortByCopasityRoom(){
		return getRoomCon().sortByCopasityRoom();
	}
	
	public List<RoomModel> sortByStarsRoom(){
		return getRoomCon().sortByStarsRoom();
	}
	
	public int showNumberOfFreeRooms(){
		return getRoomCon().showNumberOfFreeRooms();
	}
	
	public List<RoomModel> showChekOutDate(Date date){
		return getRoomCon().showChekOutDate(date);
	}
	
	public String showRoomDetails(int number){
		return getRoomCon().showRoomDetails(number);
	}
	
	public String showPricePerRoom(String name){
		return getRoomCon().showPricePerRoom(name);
	}
	
	public List<GuestModel> showLastThreeGuests(int number){
		return getRoomCon().showLastThreeGuests(number);
	}
	
	public void addGuestInRoom(int number, String name){
		getRoomCon().addGuestInRoom(number, name);
	}
	
	public List<RoomModel> printRoom(){
		return getRoomCon().printRoom();
	}
	
	public void addService(ServiceModel service){
		getServiceCon().addService(service);
	}
	
	public void deleteService(String name){
		getServiceCon().deleteService(name);
	}
	
	public void changeServicesCoast(String name, int coast){
		getServiceCon().changeServicesCoast(name, coast);
	}
	
	public List<ServiceModel> printService(){
		return getServiceCon().printService();
	}
	
	public void cloneRoom(int number){
		getRoomCon().cloneRoom(number);
	}
	
	public void exportGuests(){
		getGuestCon().exportGuests();
	}
	
	public void exportRooms(){
		getRoomCon().exportRooms();
	}
	
	public void exportServices(){
		getServiceCon().exportServices();
	}
	
	public void importServices(){
		getServiceCon().importServices();
	}
	
	public void importRooms(){
		getRoomCon().importRooms();
	}
	
	public void importGuests(){
		getGuestCon().importGuests();
	}
	
	public void buildServicesFromAnnot(){
		getServiceCon().buildServicesFromAnnot();
	}
	public void buildGuestsFromAnnot(){
		getGuestCon().buildGuestsFromAnnot();
	}
	public void buildRoomsFromAnnot(){
		getRoomCon().buildRoomsFromAnnot();
	}

}
