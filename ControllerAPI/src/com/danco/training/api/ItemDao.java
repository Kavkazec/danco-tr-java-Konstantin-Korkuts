package com.danco.training.api;

import java.sql.Connection;
import java.util.List;

import com.danco.training.entity.BaseEntity;
import com.danco.training.persistexception.PersistenceException;

public interface ItemDao <T extends BaseEntity> {

	public T getById(Connection connection, int id) throws PersistenceException;
	
	public List<T> getAll(Connection connection) throws PersistenceException;
	
	public void add(Connection connection, T model) throws PersistenceException;
	
	public void delete(Connection connection, T model) throws PersistenceException;
	
	public void update(Connection connection, T model) throws PersistenceException;
}
