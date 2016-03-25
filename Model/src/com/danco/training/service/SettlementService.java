package com.danco.training.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.danco.training.dao.SettlementDao;
import com.danco.training.dao.factory.DaoFactory;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.services.api.ISettlementService;

public class SettlementService implements ISettlementService {
	private static final Logger LOGGER = Logger.getLogger(RoomService.class);
	private SettlementDao dao = DaoFactory.getSettlementDao();
	public String getPath() {
		try {
			PropertiesReader prop = PropertiesReader.getInstance();
			prop.setProperties();
			return prop.getUtil().getCsvPath();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public Connection getConnection() {
		try {
			return ConnectionProvider.getInstance().getConnection();
		} catch (PersistenceException e) {
			LOGGER.error(e);
			return null;

		}
	}

	@Override
	public List<Settlement> getAll() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	@Override
	public void add(Settlement model) {
		try {
			dao.add(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void delete(Settlement model) {
		try {
			dao.delete(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void update(Settlement model) {
		try {
			dao.update(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	@Override
	public List<Room> releasedInTheFuture(Date date) {
		List<Room> rooms = null;
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		try {
			rooms = new ArrayList<Room>();
			List<Settlement> list = dao.getAll(getConnection());
			for (Settlement settlement : list) {
				if(settlement.getDateOfDeparture().equals(sqlDate)){
					rooms.add(settlement.getRoom());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
		return rooms;
	}

	@Override
	public List<Guest> showLastThreeGuest(Room room) {
		List<Guest> list = null;
		try {
			list = new ArrayList<Guest>();
			List<Settlement> s = dao.getAll(getConnection());
			for(int i = s.size()-1; i>=0; i--){
				if(list.size() < 3 && s.get(i).getRoom().getNumber() == room.getNumber()){
					list.add(s.get(i).getGuest());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return list;
	}

	@Override
	public int paiForRoom(Guest guest) {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	@Override
	public int servicesAndRoomsPriceSortedByCoast() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	@Override
	public int servicesAndRoomsPriceSortedByType() {
		try {
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	@Override
	public List<String> listGuestsAndRoomsSortedByName() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<String> listGuestsAndRoomsSortedByDate() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<Service> listGuestServicesSortedByCoast(Guest guest) {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<Service> listGuestServicesSortedByDate(Guest guest) {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public Settlement getByIdSettlement(int id) {
		try{
			return dao.getById(getConnection(), id);
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
}
