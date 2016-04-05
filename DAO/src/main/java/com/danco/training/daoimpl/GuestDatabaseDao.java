package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.api.IGuestDao;
import com.danco.training.entity.Guest;
import com.danco.training.persisexception.PersistenceException;

public class GuestDatabaseDao implements IGuestDao{
	private static GuestDatabaseDao instance;
	public static GuestDatabaseDao getInsatnce(){
		if(instance == null){
			instance = new GuestDatabaseDao();
		}
		return instance;
	}
	@Override
	public Guest getById(Session session, int id) throws PersistenceException {
		Guest guest = null;
		try {
			guest = (Guest) session.load(Guest.class, id);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return guest;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getAll(Session session) throws PersistenceException {
		List<Guest> guests = new ArrayList<Guest>();
		try {
			guests = session.createCriteria(Guest.class).list();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return guests;
	}
	@Override
	public void add(Session session, Guest model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	@Override
	public void delete(Session session, Guest model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	@Override
	public void update(Session session, Guest model) throws PersistenceException {
		try {
			session.beginTransaction();
			session.update(model);
			session.getTransaction().commit();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	
}
