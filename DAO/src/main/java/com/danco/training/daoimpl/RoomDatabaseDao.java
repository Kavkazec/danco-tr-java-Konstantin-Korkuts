package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.api.IRoomDao;
import com.danco.training.entity.Room;
import com.danco.training.persisexception.PersistenceException;

public class RoomDatabaseDao implements IRoomDao {
	private static RoomDatabaseDao instance;

	public static RoomDatabaseDao getInsatnce() {
		if (instance == null) {
			instance = new RoomDatabaseDao();
		}
		return instance;
	}

	@Override
	public Room getById(Session session, int id) throws PersistenceException {
		Room room = null;
		try {
			room = session.load(Room.class, id);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return room;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getAll(Session session) throws PersistenceException {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = session.createCriteria(Room.class).list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@Override
	public void add(Session session, Room model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@Override
	public void delete(Session session, Room model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@Override
	public void update(Session session, Room model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.update(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> sortRoomsBy(Session session, String status, String criterion) throws PersistenceException {
		List<Room> rooms = new ArrayList<Room>();
		try {
			if (StatusForSortRoom.All.equals(StatusForSortRoom.valueOf(status))) {
				rooms = session.createQuery("from Room where order by " + criterion).list();
			}
			if (StatusForSortRoom.Free.equals(StatusForSortRoom.valueOf(status))) {
				rooms = session.createQuery("from Room where isFreeRoom=true order by " + criterion).list();
			}
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int numberOfFreeRooms(Session session) throws PersistenceException {
		int countFreeRooms = 0;
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = session.createQuery("from Room where isFreeRoom=true").list();
			countFreeRooms = rooms.size();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return countFreeRooms;
	}
}
