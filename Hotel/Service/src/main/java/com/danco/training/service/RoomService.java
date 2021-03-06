package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IRoomDao;
import com.danco.training.api.IRoomService;
import com.danco.training.daoimpl.RoomDaoImpl;
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
	//private IRoomDao dao = (IRoomDao) DependencyInjection.getInstance().getClassInstance(IRoomDao.class);
	private IRoomDao dao = new RoomDaoImpl();
	
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
			session.beginTransaction();
			dao.add(session, room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
			session.beginTransaction();
			dao.delete(session, room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Room> getRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Room> rooms = null;
		try {
			session.beginTransaction();
			rooms = dao.getAll(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return rooms;
	}

	public void cloneRoom(Room model) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Room room = model.clone();
			this.addRoom(room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void exportRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.writeToFileRooms(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void importRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.writeToFileRooms(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void updateRoom(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
			session.beginTransaction();
			dao.update(session, room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
			session.beginTransaction();
			dao.update(session, room);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public int numberOfFreeRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int countOfFreeRooms = 0;
		try {
			session.beginTransaction();
			countOfFreeRooms = dao.listOfFreeRooms(session).size();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return countOfFreeRooms;
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
		} 
		return str;
	}

	public Room getByIdRoom(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Room room = null;
		try {
			session.beginTransaction();
			room = dao.getById(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return room;
	}

	public List<Room> sortRoomsBy(String status, String criterion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Room> rooms = null;
		try {
			session.beginTransaction();
			rooms = dao.sortRoomsBy(session, status, criterion);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return rooms;
	}

}
