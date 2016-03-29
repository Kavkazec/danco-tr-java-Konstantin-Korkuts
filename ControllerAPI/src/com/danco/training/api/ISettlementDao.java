package com.danco.training.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;

public interface ISettlementDao extends ItemDao<Settlement>{
	public List<Room> releasedInTheFuture(Connection con, Date date) throws PersistenceException;
	public int paiForRoom(Connection con, Guest guest) throws PersistenceException;
	public List<String> servicesAndRoomsPriceSortedByCoast(Connection con) throws PersistenceException;
	public List<String> servicesAndRoomsPriceSortedByType(Connection con) throws PersistenceException;
	public List<String> listGuestsAndRoomsSortedByName(Connection con) throws PersistenceException;
	public List<String> listGuestsAndRoomsSortedByDate(Connection con) throws PersistenceException;
	public List<String> listGuestServicesSortedByCoast(Connection con, Guest guest) throws PersistenceException;
	public List<String> listGuestServicesSortedByDate(Connection con, Guest guest) throws PersistenceException;
	public Settlement parserRS(Connection con, ResultSet result) throws PersistenceException;
}
