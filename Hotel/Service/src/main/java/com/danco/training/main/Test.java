package com.danco.training.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.danco.training.daoimpl.GuestDaoImpl;
import com.danco.training.daoimpl.RoomDaoImpl;
import com.danco.training.entity.Guest;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.properties.HibernateUtil;

public class Test {
	public static void main(String[] args) throws PersistenceException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSessionFactory().openSession();
		GuestDaoImpl gdd = GuestDaoImpl.getInsatnce();
		RoomDaoImpl rdd = RoomDaoImpl.getInsatnce();
		Guest guest = gdd.getById(session, 1);
		
		System.out.println(guest.getName());
	}
}
