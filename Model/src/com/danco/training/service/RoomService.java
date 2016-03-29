package com.danco.training.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IRoomDao;
import com.danco.training.api.IRoomService;
import com.danco.training.api.ISettlementService;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Room;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomService.
 */
public class RoomService implements IRoomService{
	private static final Logger LOGGER = Logger.getLogger(RoomService.class);
	private ImportAndExport ie = ImportAndExport.getInstance();
	private IRoomDao dao = (IRoomDao) DependencyInjection.getInstance().getClassInstance(IRoomDao.class);

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

	public void addRoom(Room room) {
		try {
			dao.add(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void deleteRoom(Room room) {
		try {
			dao.delete(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);

		}
	}

	public List<Room> sortByCoastFreeRoom() {
		try {
			return dao.sortFreeRoomsByCoast(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> sortByCapacityFreeRoom() {
		try {
			return dao.sortFreeRoomsByCapacity(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> sortByStarsFreeRoom() {
		try {
			return dao.sortFreeRoomsByStars(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> sortByCoastRoom() {
		try {
			return dao.sortRoomsByCoast(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> sortByCapacityRoom() {
		try {
			return dao.sortRoomsByCapacity(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> sortByStarsRoom() {
		try {
			return dao.sortRoomsByStars(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public List<Room> getRooms() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public void cloneRoom(Room model) {
		Connection conn = getConnection();
		Room room = null;
		try {
			conn.setAutoCommit(false);
			room = dao.getById(conn, model.getId()).clone();
			room.setId(dao.findLastId(conn));
			conn.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				LOGGER.error(e);
			}
		}
	}

	public void exportRooms() {
		try {
			ie.writeToFileRooms(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void importRooms() {
		try {
			ie.writeToFileRooms(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void buildRoomsFromAnnot() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void updateRoom(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	public void changeRoomStatus(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void changeRoomCoast(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public int numberOfFreeRooms() {
		int count = 0;
		try {
			for (Room room : dao.getAll(getConnection())) {
				if (room.isFreeRoom()) {
					count += 1;
				}
			}
			return count;
		} catch (Exception e) {
			LOGGER.error(e);
			return count;
		}
	}

	public String showRoomDetails(Room room) {
		String str = "";
		try {
			str = room.getId() + " " + room.getNumber() + " " + room.getCapacity() + " " + room.getNumberOfStars() + " "
					+ room.getCoast() + " " + room.isFreeRoom() + " " + room.isOnRepair();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
		return str;
	}

	public Room getByIdRoom(int id) {
		try {
			return dao.getById(getConnection(), id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}
}
