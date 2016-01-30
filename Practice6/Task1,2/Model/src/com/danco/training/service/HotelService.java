package com.danco.training.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.seriolize.SeriolizeUtil;
import com.danco.training.storage.Hotel;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelService.
 */
public class HotelService {
	private static final Logger logger = Logger.getLogger(HotelService.class);
	/** The guest serv. */
	private GuestService guestServ = new GuestService();

	/** The room serv. */
	private RoomService roomServ = new RoomService();

	/** The service serv. */
	private ServiceService serviceServ = new ServiceService();
	
	private SeriolizeUtil util = new SeriolizeUtil();
	
	/**
	 * Instantiates a new hotel service.
	 */

	private static HotelService instance = null;

	private HotelService() {

	}

	public static HotelService getInstance() {
		if (instance == null) {
			instance = new HotelService();
		}
		return instance;
	}

	/**
	 * Gets the guest serv.
	 *
	 * @return the guest serv
	 */
	public GuestService getGuestServ() {
		try {
			return guestServ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public void setHotel(Hotel hotel){
		Hotel.getInstance().setHotel(hotel);
	}
	
	public Hotel getHotel(){
		return Hotel.getInstance();
	}
	/**
	 * Gets the room serv.
	 *
	 * @return the room serv
	 */
	public RoomService getRoomServ() {
		try {
			return roomServ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Gets the service serv.
	 *
	 * @return the service serv
	 */
	public ServiceService getServiceServ() {
		try {
			return serviceServ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public List<GuestModel> getGuests() {
		try {
			return getGuestServ().getGuests();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Adds the guest.
	 *
	 * @param guest
	 *            the guest
	 */
	public void addGuest(GuestModel guest) {
		try {
			getGuestServ().addGuest(guest);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Delete guest.
	 *
	 * @param guest
	 *            the guest
	 */
	public void deleteGuest(String str) {

		try {
			getGuestServ().deleteGuest(str);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Sort by name guests.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByNameGuests() {

		try {
			return getGuestServ().sortByName();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Sort by date guests.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByDateGuests() {

		try {
			return getGuestServ().sortByDate();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show number of guests.
	 *
	 * @return the int
	 */
	public int showNumberOfGuests() {

		try {
			return getGuestServ().showAllGuests();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * Show guests services sorted by coast.
	 *
	 * @param guest
	 *            the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name) {

		try {
			return getGuestServ().showListOfServicesSortedByCoast(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show guests services sorted by date.
	 *
	 * @param guest
	 *            the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByDate(String name) {

		try {
			return getGuestServ().showListOfServicesSortedByDate(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<ServiceModel> getServices() {
		try {
			return getServiceServ().getServices();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Adds the service.
	 *
	 * @param service
	 *            the service
	 */
	public void addService(ServiceModel service) {

		try {
			getServiceServ().addService(service);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Delete service.
	 *
	 * @param service
	 *            the service
	 */
	public void deleteService(String name) {

		try {
			getServiceServ().deleteService(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Change services coast.
	 *
	 * @param name
	 *            the name
	 * @param coast
	 *            the coast
	 */
	public void changeServicesCoast(String name, int coast) {

		try {
			getServiceServ().changeStatus(name, coast);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public List<RoomModel> getRooms() {

		try {
			return getRoomServ().getRooms();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Adds the room.
	 *
	 * @param room
	 *            the room
	 */
	public void addRoom(RoomModel room) {

		try {
			getRoomServ().addRoom(room);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Delete room.
	 *
	 * @param room
	 *            the room
	 */
	public void deleteRoom(int number) {

		try {
			getRoomServ().deleteRoom(number);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Delete guest from room.
	 *
	 * @param room
	 *            the room
	 * @param guest
	 *            the guest
	 */
	public void deleteGuestFromRoom(String name) {

		try {
			getRoomServ().deleteGuestFromRoom(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Delete all guests from room.
	 *
	 * @param room
	 *            the room
	 */
	public void deleteAllGuestsFromRoom(int number) {
		try {
			getRoomServ().deleteAllGuestsFromRoom(number);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void changeRoomsCoast(int number, int coast) {
		try {
			getRoomServ().changeCoast(number, coast);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void changeRoomsStatusRepair() {
		try {
			getRoomServ().changeStatusRepair();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * Sort by coast free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastFreeRoom() {
		try {
			return getRoomServ().sortByCoastFreeRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}

	}

	/**
	 * Sort by copasity free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityFreeRoom() {

		try {
			return getRoomServ().sortByCopasityFreeRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Sort by stars free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsFreeRoom() {

		try {
			return getRoomServ().sortByStarsFreeRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Sort by coast room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastRoom() {

		try {
			return getRoomServ().sortByCoastRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Sort by copasity room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityRoom() {

		try {
			return getRoomServ().sortByCopasityRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Sort by stars room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsRoom() {

		try {
			return getRoomServ().sortByStarsRoom();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show number of free rooms.
	 *
	 * @return the int
	 */
	public int showNumberOfFreeRooms() {

		try {
			return getRoomServ().showFreeRooms();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * Show chek out date.
	 *
	 * @param date
	 *            the date
	 * @return the list
	 */
	public List<RoomModel> showChekOutDate(Date date) {

		try {
			return getRoomServ().showChekOutDate(date);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show room details.
	 *
	 * @param room
	 *            the room
	 * @return the string
	 */
	public String showRoomDetails(int number) {

		try {
			return getRoomServ().showRoomDetails(number);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show price per room.
	 *
	 * @param guest
	 *            the guest
	 * @return the string
	 */
	public String showPricePerRoom(String name) {

		try {
			return getRoomServ().showPricePerRoom(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show last three guests.
	 *
	 * @param room
	 *            the room
	 * @return the string
	 */
	public List<GuestModel> showLastThreeGuests(int number) {

		try {
			return getRoomServ().showLastThreeGuests(number);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 */
	public void addServiceToGuest(String guest, String service) {

		try {
			getGuestServ().addServiceToGuest(guest, service);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Adds the guest in room.
	 *
	 * @param room
	 *            the room
	 * @param guest
	 *            the guest
	 */
	public void addGuestInRoom(int number, String name) {

		try {
			getRoomServ().addGuestInRoom(number, name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void cloneRoom(int number){
		try {
			roomServ.cloneRoom(number);
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	
	
	public void writeInFile(){
		PropertiesReader.getInstance().setProperties();
		util.writeInFile(PropertiesReader.getInstance().getUtil().getPath());
	}
	
	public void readFromFile(){
		PropertiesReader.getInstance().setProperties();
		util.readFromFile(PropertiesReader.getInstance().getUtil().getPath());
	}

	public void exportGuests(){
		PropertiesReader.getInstance().setProperties();
		getGuestServ().exportGuests(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
	
	public void exportRooms(){
		PropertiesReader.getInstance().setProperties();
		getRoomServ().exportRooms(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
	
	public void exportServices(){
		PropertiesReader.getInstance().setProperties();
		getServiceServ().exportServices(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
	public void importServices(){
		PropertiesReader.getInstance().setProperties();
		getServiceServ().importServices(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
	public void importRooms(){
		PropertiesReader.getInstance().setProperties();
		getRoomServ().importRooms(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
	
	public void importGuests(){
		PropertiesReader.getInstance().setProperties();
		getGuestServ().importGuests(PropertiesReader.getInstance().getUtil().getCsvPath());
	}
}
