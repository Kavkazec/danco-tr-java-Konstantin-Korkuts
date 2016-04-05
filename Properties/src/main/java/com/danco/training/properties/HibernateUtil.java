package com.danco.training.properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	static{
		Configuration cfg = new Configuration().configure();
		cfg.addAnnotatedClass(Room.class);
		cfg.addAnnotatedClass(Guest.class);
		cfg.addAnnotatedClass(Service.class);
		cfg.addAnnotatedClass(Settlement.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(builder.build());
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}	
