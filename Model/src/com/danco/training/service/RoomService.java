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
	private static final String EMPTY_STRING = " ";
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
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public void deleteRoom(Room room) {
		try {
			dao.delete(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);

		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public List<Room> getRooms() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
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
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
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
	public void updateRoom(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}

	}

	@Override
	public void changeRoomStatus(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public void changeRoomCoast(Room room) {
		try {
			dao.update(getConnection(), room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public int numberOfFreeRooms() {
		try {
			return dao.numberOfFreeRooms(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public String showRoomDetails(Room room) {
		String str = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(room.getId());
			sb.append(EMPTY_STRING);
			sb.append(room.getNumber());
			sb.append(EMPTY_STRING);
			sb.append(room.getCapacity());
			sb.append(EMPTY_STRING);
			sb.append(room.getNumberOfStars());
			sb.append(EMPTY_STRING);
			sb.append(room.getCoast());
			sb.append(EMPTY_STRING);
			sb.append(room.isFreeRoom());
			sb.append(EMPTY_STRING);
			sb.append(room.isOnRepair());
			sb.append(EMPTY_STRING);
			str = sb.toString();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
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
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	@Override
	public List<Room> sortRoomsBy(String status, String criterion) {
		try {
			return dao.sortRoomsBy(getConnection(), status, criterion);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

}
