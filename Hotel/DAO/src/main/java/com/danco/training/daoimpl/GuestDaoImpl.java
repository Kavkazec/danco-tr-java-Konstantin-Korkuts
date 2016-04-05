package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.api.IGuestDao;
import com.danco.training.entity.Guest;
import com.danco.training.persisexception.PersistenceException;

public class GuestDaoImpl implements IGuestDao{
	private static GuestDaoImpl instance;
	public static GuestDaoImpl getInsatnce(){
		if(instance == null){
			instance = new GuestDaoImpl();
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
			session.save(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	@Override
	public void delete(Session session, Guest model) throws PersistenceException {
		try {
			session.delete(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	@Override
	public void update(Session session, Guest model) throws PersistenceException {
		try {
			session.update(model);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
	}
	
}
