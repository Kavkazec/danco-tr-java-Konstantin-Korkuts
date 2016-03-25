package com.danco.training.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;

public interface SettlementDao extends ItemDao<Settlement>{
	public List<Room> releasedInTheFuture(Connection con, Date date) throws PersistenceException;
	public int paiForRoom(Connection con, Guest guest) throws PersistenceException;
	public int servicesAndRoomsPriceSortedByCoast(Connection con) throws PersistenceException;
	public int servicesAndRoomsPriceSortedByType(Connection con) throws PersistenceException;
	public List<String> listGuestsAndRoomsSortedByName(Connection con) throws PersistenceException;
	public List<String> listGuestsAndRoomsSortedByDate(Connection con) throws PersistenceException;
	public List<Service> listGuestServicesSortedByCoast(Connection con, Guest guest) throws PersistenceException;
	public List<Service> listGuestServicesSortedByDate(Connection con, Guest guest) throws PersistenceException;
	public Settlement parserRS(Connection con, ResultSet result) throws PersistenceException;
}
