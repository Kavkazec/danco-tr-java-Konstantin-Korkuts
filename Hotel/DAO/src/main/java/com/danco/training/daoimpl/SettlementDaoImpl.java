package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
		List<Settlement> settlements = new ArrayList<Settlement>();
		try {
			settlements = session.createCriteria(Settlement.class).list();
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
		List<Room> rooms = new ArrayList<Room>();
		try {
			String str = "select distinct s.room from Settlement as s where s.dateOfDeparture = ?";
			rooms = session.createQuery(str).setDate(0, date).list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@Override
	public List<String> servicesAndRoomsPriceSortedBy(Session session, String string) throws PersistenceException {
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Settlement> listGuestsAndRoomsSortedBy(Session session, String string) throws PersistenceException {
		List<Settlement> list = null;
		try {
			if(string.equals("name")){
				Query q = session.createQuery("from Settlement AS s order by s.guest.name");
				list = q.list();
			}
			if(string.equals("date")){
				Query q = session.createQuery("from Settlement AS s order by dateOfDeparture");
				list = q.list();
			}
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
			list = session.createQuery("from Settlement AS s where s.room = ?")
					.setEntity(0, room).list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return list;
	}

	@Override
	public Settlement getSettlementByGuest(Session session, Guest guest) throws PersistenceException {
		Settlement settlement = null;
		try {
			settlement = (Settlement) session.createQuery("from Settlement AS s where s.guest = ? AND isPaid=false")
					.setEntity(0, guest).uniqueResult();
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
			Query q = session.createQuery("from Service where settlement = ? order by " + string);
			q.setEntity(0, settlement);
			list = q.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return list;
	}

	@Override
	public Settlement getSettlementByGuestAndRoom(Session session, Room room, Guest guest) throws PersistenceException {
		Settlement settlement = null;
		try {
			Query q = session.createQuery("from Settlement where room = :room AND guest = :guest AND isPaid=false");
			q.setEntity("room", room);
			q.setEntity("guest", guest);
			settlement = (Settlement) q.uniqueResult();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return settlement;
	}
}
