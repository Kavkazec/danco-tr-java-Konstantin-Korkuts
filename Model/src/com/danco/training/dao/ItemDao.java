package com.danco.training.dao;

import java.util.List;

import com.danco.training.dbentity.BaseEntity;
import com.danco.training.persistexception.PersistenceException;

public interface ItemDao <T extends BaseEntity> {

	public T getById(int id) throws PersistenceException;
	
	public List<T> getAll() throws PersistenceException;
	
	public void add(T model) throws PersistenceException;
	
	public void delete(T model) throws PersistenceException;
	
	public void update(T model) throws PersistenceException;
}
