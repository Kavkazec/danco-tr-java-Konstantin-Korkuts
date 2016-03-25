package com.danco.training.dao;

import java.sql.ResultSet;

import com.danco.training.entity.Service;
import com.danco.training.persistexception.PersistenceException;

public interface ServiceDao extends ItemDao<Service>{
	public Service parserRS(ResultSet result) throws PersistenceException;
}
