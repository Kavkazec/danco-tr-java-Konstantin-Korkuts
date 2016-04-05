package com.danco.training.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.danco.training.daoimpl.GuestDatabaseDao;
import com.danco.training.daoimpl.RoomDatabaseDao;
import com.danco.training.entity.Guest;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.properties.HibernateUtil;

public class Test {
	public static void main(String[] args) throws PersistenceException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSessionFactory().openSession();
		GuestDatabaseDao gdd = GuestDatabaseDao.getInsatnce();
		RoomDatabaseDao rdd = RoomDatabaseDao.getInsatnce();
		Guest guest = gdd.getById(session, 1);
		
		System.out.println(guest.getSettlementList().size());
	}
}
