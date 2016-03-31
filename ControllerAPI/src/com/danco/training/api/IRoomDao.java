package com.danco.training.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.danco.training.entity.Room;
import com.danco.training.persistexception.PersistenceException;

public interface IRoomDao extends ItemDao<Room>{
	public List<Room> sortRoomsBy(Connection connection, String string) throws PersistenceException;
	
	public List<Room> sortFreeRoomsBy(Connection connection, String string) throws PersistenceException;
	
	public int findLastId(Connection connection) throws PersistenceException;
	
	public Room parserRS(ResultSet result) throws PersistenceException;
}
