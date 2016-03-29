package com.danco.training.api;

import java.sql.ResultSet;

import com.danco.training.entity.Service;
import com.danco.training.persistexception.PersistenceException;

public interface IServiceDao extends ItemDao<Service>{
	public Service parserRS(ResultSet result) throws PersistenceException;
}
