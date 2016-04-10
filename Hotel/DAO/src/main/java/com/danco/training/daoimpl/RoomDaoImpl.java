package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.danco.training.api.IRoomDao;
import com.danco.training.entity.Room;
import com.danco.training.persisexception.PersistenceException;

public class RoomDaoImpl implements IRoomDao {
	private static RoomDaoImpl instance;

	public static RoomDaoImpl getInsatnce() {
		if (instance == null) {
			instance = new RoomDaoImpl();
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
			session.save(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@Override
	public void delete(Session session, Room model) throws PersistenceException {
		try {
			session.delete(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@Override
	public void update(Session session, Room model) throws PersistenceException {
		try {
			session.update(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> sortRoomsBy(Session session, String status, String criterion) throws PersistenceException {
		List<Room> rooms = null;
		Map<String,Criterion> map = new HashMap<String,Criterion>();
		map.put("All", Restrictions.isNotNull("id"));
		map.put("Free", Restrictions.eq("isFreeRoom", true));
		try {
			Criteria cr = session.createCriteria(Room.class);
			cr.add((Criterion) map.get(status));
			cr.addOrder(Order.asc(criterion));
			rooms = cr.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> listOfFreeRooms(Session session) throws PersistenceException {
		List<Room> rooms = null;
		try {
			Criteria cr = session.createCriteria(Room.class);
			cr.add(Restrictions.eq("isFreeRoom", true));
			rooms = cr.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}
}
