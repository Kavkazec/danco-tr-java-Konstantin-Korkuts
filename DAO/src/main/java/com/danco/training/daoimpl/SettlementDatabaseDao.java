package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.api.ISettlementDao;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;

public class SettlementDatabaseDao implements ISettlementDao {

	private static SettlementDatabaseDao instance;

	public static SettlementDatabaseDao getInsatnce() {
		if (instance == null) {
			instance = new SettlementDatabaseDao();
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
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}

	@Override
	public void delete(Session session, Settlement model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}

	@Override
	public void update(Session session, Settlement model) throws PersistenceException {
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
	public List<Room> releasedInTheFuture(Session session, Date date) throws PersistenceException {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = session.createQuery("from Settlement  ").list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return rooms;
	}

	@Override
	public int paiForRoom(Session session, Guest guest) throws PersistenceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> servicesAndRoomsPriceSortedBy(Session session, String string) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listGuestsAndRoomsSortedBy(Session session, String string) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listGuestServicesSortedBy(Session session, Guest guest, String string)
			throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addServiceToGuest(Session session, Guest guest, Service service, Date date)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSetToGuest(Session session, Guest guests) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
}
