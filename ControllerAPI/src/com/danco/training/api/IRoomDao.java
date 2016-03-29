package com.danco.training.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.danco.training.entity.Room;
import com.danco.training.persistexception.PersistenceException;

public interface IRoomDao extends ItemDao<Room>{
	public List<Room> sortRoomsByCapacity(Connection connection) throws PersistenceException;
	
	public List<Room> sortRoomsByCoast(Connection connection) throws PersistenceException;
	
	public List<Room> sortRoomsByStars(Connection connection) throws PersistenceException;
	
	public List<Room> sortFreeRoomsByCapacity(Connection connection) throws PersistenceException;
	
	public List<Room> sortFreeRoomsByCoast(Connection connection) throws PersistenceException;
	
	public List<Room> sortFreeRoomsByStars(Connection connection) throws PersistenceException;
	
	public int findLastId(Connection connection) throws PersistenceException;
	
	public Room parserRS(ResultSet result) throws PersistenceException;
}
