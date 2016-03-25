package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.danco.training.dao.impl.GuestDatabaseDao;
import com.danco.training.dao.impl.SettlementDatabaseDao;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;

public class Test {
	public static void main(String[] args) throws PersistenceException {
		ConnectionProvider c = ConnectionProvider.getInstance();
		SettlementDatabaseDao sdd = SettlementDatabaseDao.getInstance();
		GuestDatabaseDao gdd = GuestDatabaseDao.getInstance();
		Guest guest = gdd.getById(c.getConnection(), 6);
		System.out.println(sdd.paiForRoom(c.getConnection(), guest));
		
		
		
	}
}
