package com.danco.training.api;

import java.sql.Connection;
import java.sql.ResultSet;

import com.danco.training.entity.Guest;
import com.danco.training.persistexception.PersistenceException;

public interface IGuestDao extends ItemDao<Guest> {
	public Guest parserRS(ResultSet result) throws PersistenceException;
}
