package com.danco.training.dao;

import java.sql.ResultSet;

import com.danco.training.entity.Guest;
import com.danco.training.persistexception.PersistenceException;

public interface GuestDao extends ItemDao<Guest> {
	public Guest parserRS(ResultSet result) throws PersistenceException;
}
