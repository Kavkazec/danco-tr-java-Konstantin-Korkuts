package com.danco.training.api;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.entity.BaseEntity;
import com.danco.training.persisexception.PersistenceException;

public interface ItemDao <T extends BaseEntity> {

	public T getById(Session session, int id) throws PersistenceException;
	
	public List<T> getAll(Session session) throws PersistenceException;
	
	public void add(Session session, T model) throws PersistenceException;
	
	public void delete(Session session, T model) throws PersistenceException;
	
	public void update(Session session, T model) throws PersistenceException;
}
