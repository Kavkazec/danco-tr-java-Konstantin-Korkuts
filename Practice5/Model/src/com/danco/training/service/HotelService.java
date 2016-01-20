package com.danco.training.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.logger.Config;
import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelService.
 */
public class HotelService {
	private static final String LOGFILE = "log4j.properties";
	private static Config config = new Config(LOGFILE);
	private static final Logger logger = Logger.getLogger(HotelService.class);
	/** The guest serv. */
	private GuestService guestServ = new GuestService();

	/** The room serv. */
	private RoomService roomServ = new RoomService();

	/** The service serv. */
	private ServiceService serviceServ = new ServiceService();

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
			config.init();
			return guestServ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Gets the room serv.
	 *
	 * @return the room serv
	 */
	public RoomService getRoomServ() {
		try {
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
			getRoomServ().deleteAllGuestsFromRoom(number);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void changeRoomsCoast(int number, int coast) {
		try {
			config.init();
			getRoomServ().changeCoast(number, coast);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void changeRoomsStatusRepair() {
		try {
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
			config.init();
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
	public String showLastThreeGuests(int number) {

		try {
			config.init();
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
			config.init();
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
			config.init();
			getRoomServ().addGuestInRoom(number, name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Write guests.
	 */

	public void writeGuests() {
		try {
			config.init();
			getGuestServ().writeGuests();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * Write rooms.
	 */

	public void writeRooms() {
		try {
			config.init();
			getRoomServ().writeRooms();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Write services.
	 */

	public void writeServices() {
		try {
			config.init();
			getServiceServ().writeServices();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Show guests from file.
	 *
	 * @return the string
	 */

	public String showGuestsFromFile() {
		try {
			config.init();
			return getGuestServ().showGuestsFromFile();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show rooms from file.
	 *
	 * @return the string
	 */

	public String showRoomsFromFile() {
		try {
			config.init();
			return getRoomServ().showRoomsFromFile();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Show services from file.
	 *
	 * @return the string
	 */

	public String showServicesFromFile() {
		try {
			config.init();
			return getServiceServ().showServicesFromFile();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
