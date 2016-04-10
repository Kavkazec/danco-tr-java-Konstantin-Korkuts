package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.danco.training.api.ISettlementDao;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;

public class SettlementDaoImpl implements ISettlementDao {

	private static SettlementDaoImpl instance;

	public static SettlementDaoImpl getInsatnce() {
		if (instance == null) {
			instance = new SettlementDaoImpl();
		}
		return instance;
	}

	@Override
	public Settlement getById(Session session, int id) throws PersistenceException {
		Settlement settlement = null;
		try {
			settlement = (Settlement) session.load(Settlement.class, id);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return settlement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Settlement> getAll(Session session) throws PersistenceException {
		List<Settlement> settlements = null;
		try {
			Criteria empQuery = session.createCriteria(Settlement.class)
					.setFetchMode("room", FetchMode.JOIN)
					.setFetchMode("guest", FetchMode.JOIN)
					.setFetchMode("serviceList", FetchMode.JOIN);
			settlements = empQuery.list();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return settlements;
	}

	@Override
	public void add(Session session, Settlement model) throws PersistenceException {
		try {
			session.save(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}

	@Override
	public void delete(Session session, Settlement model) throws PersistenceException {
		try {
			session.delete(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}

	@Override
	public void update(Session session, Settlement model) throws PersistenceException {
		try {
			session.update(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> releasedInTheFuture(Session session, Date date) throws PersistenceException {
		List<Room> rooms = null;
		try {
			Criteria cr = session.createCriteria(Settlement.class);
			cr.createCriteria("room");
			cr.add(Restrictions.eq("dateOfDeparture", date));
			rooms = cr.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Settlement> listGuestsAndRoomsSortedBy(Session session, String string) throws PersistenceException {
		List<Settlement> list = null;
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","g.name");
		map.put("date","dateOfDeparture");
		try {
			Criteria cr = session.createCriteria(Settlement.class).createAlias("guest", "guest");
			cr.addOrder(Order.asc(map.get(string)))	
				.setFetchMode("room", FetchMode.JOIN)
				.setFetchMode("guest", FetchMode.JOIN)
				.setFetchMode("serviceList", FetchMode.JOIN);
			list = cr.list();	
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Settlement> showLastThreeGuest(Session session, Room room) throws PersistenceException {
		List<Settlement> list = null;
		try { 
			Criteria cr = session.createCriteria(Settlement.class).createAlias("room", "room")
					.add(Restrictions.eq("room",room));
			cr.setFetchMode("room", FetchMode.JOIN)
				.setFetchMode("guest", FetchMode.JOIN)
				.setFetchMode("serviceList", FetchMode.JOIN);	
			list = cr.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return list;
	}

	@Override
	public Settlement getSettlementByGuest(Session session, Guest guest) throws PersistenceException {
		Settlement settlement = null;
		try {
			Criteria cr = session.createCriteria(Settlement.class).createAlias("guest", "guest")
					.add(Restrictions.eq("guest", guest)).add(Restrictions.eq("isPaid",false));
			settlement = (Settlement) cr.uniqueResult();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return settlement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> listGuestServicesSortedBy(Session session, Settlement settlement, String string) throws PersistenceException {
		List<Service> list = null;
		try {
			Criteria cr = session.createCriteria(Service.class).add(Restrictions.eq("settlement", settlement))
					.addOrder(Order.asc(string)).setFetchMode("settlement", FetchMode.JOIN);
			list = cr.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return list;
	}

	@Override
	public Settlement getSettlementByGuestAndRoom(Session session, Room room, Guest guest) throws PersistenceException {
		Settlement settlement = null;
		try {
			Criteria cr = session.createCriteria(Settlement.class).add(Restrictions.eq("room", room))
					.add(Restrictions.eq("guest", guest)).add(Restrictions.eq("isPaid", false));
			settlement = (Settlement) cr.uniqueResult();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return settlement;
	}
}
