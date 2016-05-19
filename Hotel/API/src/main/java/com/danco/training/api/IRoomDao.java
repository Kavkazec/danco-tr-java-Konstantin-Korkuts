package com.danco.training.api;

import java.util.List;

import org.hibernate.Session;

import com.danco.training.entity.Room;
import com.danco.training.persisexception.PersistenceException;

public interface IRoomDao extends ItemDao<Room>{
	public List<Room> sortRoomsBy(Session session, String status, String criterion) throws PersistenceException;
	
	public List<Room> listOfFreeRooms(Session session) throws PersistenceException;
}
