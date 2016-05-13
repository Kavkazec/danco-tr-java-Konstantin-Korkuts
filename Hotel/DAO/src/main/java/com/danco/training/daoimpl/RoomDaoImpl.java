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

import com.danco.training.api.IRoomDao;
import com.danco.training.entity.Room;
import com.danco.training.persisexception.PersistenceException;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements IRoomDao {
	
	public RoomDaoImpl(){
		super(Room.class);
	}

	@SuppressWarnings("unchecked")
	public List<Room> getAll(Session session) throws PersistenceException {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = session.createCriteria(Room.class).list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@SuppressWarnings("unchecked")
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
