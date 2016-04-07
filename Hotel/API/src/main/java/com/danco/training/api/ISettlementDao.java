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
	
	public List<String> servicesAndRoomsPriceSortedBy(Session session, String string) throws PersistenceException;
	
	public List<Settlement> listGuestsAndRoomsSortedBy(Session session, String string) throws PersistenceException;
	
	public Settlement getSettlementByGuest(Session session, Guest guest) throws PersistenceException;
	
	public List<Settlement> showLastThreeGuest(Session session, Room room) throws PersistenceException;
	
	public List<Service> listGuestServicesSortedBy(Session session, Settlement settlement, String string) throws PersistenceException;
	
	public Settlement  getSettlementByGuestAndRoom(Session session, Room room, Guest guest) throws PersistenceException;
	
}
