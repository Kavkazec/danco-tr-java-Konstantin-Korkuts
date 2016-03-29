package com.danco.training.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.ISettlementDao;
import com.danco.training.api.ISettlementService;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

public class SettlementService implements ISettlementService {
	private static final Logger LOGGER = Logger.getLogger(RoomService.class);
	private ISettlementDao dao = (ISettlementDao) DependencyInjection.getInstance().getClassInstance(ISettlementDao.class);
	private ImportAndExport ie = ImportAndExport.getInstance();

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

	public List<Settlement> getAll() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public void add(Settlement model) {
		try {
			dao.add(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void delete(Settlement model) {
		try {
			dao.delete(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void update(Settlement model) {
		try {
			dao.update(getConnection(), model);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public List<Room> releasedInTheFuture(Date date) {
		List<Room> rooms = null;
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		try {
			rooms = new ArrayList<Room>();
			List<Settlement> list = dao.getAll(getConnection());
			for (Settlement settlement : list) {
				if (settlement.getDateOfDeparture().equals(sqlDate)) {
					rooms.add(settlement.getRoom());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
		return rooms;
	}

	public List<Guest> showLastThreeGuest(Room room) {
		List<Guest> list = null;
		try {
			list = new ArrayList<Guest>();
			List<Settlement> s = dao.getAll(getConnection());
			for (int i = s.size() - 1; i >= 0; i--) {
				if (list.size() < 3 && s.get(i).getRoom().getNumber() == room.getNumber()) {
					list.add(s.get(i).getGuest());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return list;
	}

	public int paiForRoom(Guest guest) {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return 0;
	}

	public List<String> servicesAndRoomsPriceSortedByCoast() {
		try {
			return dao.servicesAndRoomsPriceSortedByCoast(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public List<String> servicesAndRoomsPriceSortedByType() {
		try {
			return dao.servicesAndRoomsPriceSortedByType(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public List<String> listGuestsAndRoomsSortedByName() {
		try {
			return dao.listGuestsAndRoomsSortedByName(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public List<String> listGuestsAndRoomsSortedByDate() {
		try {
			return dao.listGuestsAndRoomsSortedByDate(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public List<String> listGuestServicesSortedByCoast(Guest guest) {
		try {
			return dao.listGuestServicesSortedByCoast(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
		
	}

	public List<String> listGuestServicesSortedByDate(Guest guest) {
		try {
			return dao.listGuestServicesSortedByDate(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public Settlement getByIdSettlement(int id) {
		try {
			return dao.getById(getConnection(), id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public void exportSettlements() {
		try {
			ie.writeToFileSettlements(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void importSettlements() {
		try {
			ie.readFromFileSettlements(getPath(), getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
}
