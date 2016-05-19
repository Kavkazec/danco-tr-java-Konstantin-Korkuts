package com.danco.training.daoimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.danco.training.api.ISettlementDao;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;

public class SettlementDaoImpl extends AbstractDaoImpl<Settlement> implements ISettlementDao {

	public SettlementDaoImpl(){
		super(Settlement.class);
	}

	@SuppressWarnings("unchecked")
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


	@SuppressWarnings("unchecked")
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
