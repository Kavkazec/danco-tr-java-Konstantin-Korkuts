package com.danco.training.daoimpl;

import org.hibernate.Session;

import com.danco.training.api.ItemDao;
import com.danco.training.entity.BaseEntity;
import com.danco.training.persisexception.PersistenceException;

public abstract class AbstractDaoImpl<T extends BaseEntity> implements ItemDao<T>{

	private final Class<T> genericClass;

	protected AbstractDaoImpl(Class<T> genericClass) {
		this.genericClass = genericClass;
	}

	public Class<T> getGenericClass() {
		return genericClass;
	}
	
	public T getById(Session session, int id) throws PersistenceException {
		try {
			return (T) session.get(getGenericClass(), id);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		
	}
	
	public void add(Session session, T model) throws PersistenceException {
		try {
			session.save(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
	
	public void delete(Session session, T model) throws PersistenceException {
		try {
			session.delete(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
	
	public void update(Session session, T model) throws PersistenceException {
		try {
			session.update(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
	
}
