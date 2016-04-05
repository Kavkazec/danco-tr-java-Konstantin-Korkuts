package com.danco.training.api;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;

public interface ISettlementDao extends ItemDao<Settlement>{
	public List<Room> releasedInTheFuture(Session session, Date date) throws PersistenceException;
	
	public int paiForRoom(Session session, Guest guest) throws PersistenceException;
	
	public List<String> servicesAndRoomsPriceSortedBy(Session session, String string) throws PersistenceException;
	
	public List<String> listGuestsAndRoomsSortedBy(Session session, String string) throws PersistenceException;
	
	public List<String> listGuestServicesSortedBy(Session session, Guest guest , String string) throws PersistenceException;
		
	public void addServiceToGuest(Session session, Guest guest, Service service, Date date) throws PersistenceException;
	
	public void addSetToGuest(Session session, Guest guests) throws PersistenceException;
}
