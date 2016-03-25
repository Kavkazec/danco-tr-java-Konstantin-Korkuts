package com.danco.training.dao.factory;

import com.danco.training.dao.GuestDao;
import com.danco.training.dao.RoomDao;
import com.danco.training.dao.ServiceDao;
import com.danco.training.dao.SettlementDao;
import com.danco.training.dao.impl.GuestDatabaseDao;
import com.danco.training.dao.impl.RoomDatabaseDao;
import com.danco.training.dao.impl.ServiceDatabaseDao;
import com.danco.training.dao.impl.SettlementDatabaseDao;

public class DaoFactory {
	
	private static DaoFactory dao;
	public static void setDaoFactory(DaoFactory dao){
		DaoFactory.dao = dao;
	}
	public static DaoFactory getDaoFactory(){
		return dao;
	}
	
	public static GuestDao getGuestDao(){
		return GuestDatabaseDao.getInstance();
	}
	
	public static RoomDao getRoomDao(){
		return RoomDatabaseDao.getInstance();
	}
	
	public static ServiceDao getServiceDao(){
		return ServiceDatabaseDao.getInstance();
	}
	
	public static SettlementDao getSettlementDao(){
		return SettlementDatabaseDao.getInstance();
	}
}
