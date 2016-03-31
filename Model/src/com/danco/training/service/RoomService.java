package com.danco.training.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IRoomDao;
import com.danco.training.api.IRoomService;
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

	@Override
	public void addRoom(Room room) {
		try {
			dao.add(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void deleteRoom(Room room) {
		try {
			dao.delete(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);

		}
	}

	@Override
	public List<Room> getRooms() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	@Override
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

	@Override
	public void exportRooms() {
		try {
			ie.writeToFileRooms(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void importRooms() {
		try {
			ie.writeToFileRooms(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void buildRoomsFromAnnot() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void updateRoom(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Override
	public void changeRoomStatus(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void changeRoomCoast(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
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

	@Override
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

	@Override
	public Room getByIdRoom(int id) {
		try {
			return dao.getById(getConnection(), id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortRoomsBy(String string) {
		try {
			return dao.sortRoomsBy(getConnection(), string);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortFreeRoomsBy(String string) {
		try {
			return dao.sortFreeRoomsBy(getConnection(), string);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}
}
