package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IRoomDao;
import com.danco.training.api.IRoomService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Room;
import com.danco.training.properties.HibernateUtil;
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

	public void addRoom(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.add(session, room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void deleteRoom(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.delete(session, room);
		} catch (Exception e) {
			LOGGER.error(e);

		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Room> getRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getAll(session);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}

	}

	public void cloneRoom(Room model) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			model.clone();
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
			session.getTransaction().rollback();
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
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

	public void updateRoom(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.update(session, room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}

	}

	public void changeRoomStatus(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.update(session, room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void changeRoomCoast(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.update(session, room);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public int numberOfFreeRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.numberOfFreeRooms(session);
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

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
		} 
		return str;
	}

	public Room getByIdRoom(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getById(session, id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Room> sortRoomsBy(String status, String criterion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.sortRoomsBy(session, status, criterion);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

}
