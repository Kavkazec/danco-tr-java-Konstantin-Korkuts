package com.danco.training.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

import com.danco.training.api.IGuestDao;
import com.danco.training.entity.Guest;
import com.danco.training.persisexception.PersistenceException;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements IGuestDao{
	public GuestDaoImpl(){
		super(Guest.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Guest> getAll(Session session) throws PersistenceException {
		List<Guest> guests = null;
		try {
			Criteria empQuery = session.createCriteria(Guest.class).setFetchMode("settlementList", FetchMode.JOIN);
			guests = empQuery.list();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return guests;
	}
}
