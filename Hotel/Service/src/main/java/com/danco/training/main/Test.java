package com.danco.training.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.danco.training.api.IRoomDao;
import com.danco.training.daoimpl.RoomDaoImpl;
import com.danco.training.daoimpl.SettlementDaoImpl;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.properties.HibernateUtil;
import com.danco.training.service.GuestService;
import com.danco.training.service.RoomService;
import com.danco.training.service.ServiceService;
import com.danco.training.service.SettlementService;

public class Test {
	public static void main(String[] args) throws PersistenceException, ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		RoomDaoImpl rdi = RoomDaoImpl.getInsatnce();
		for (Room room : rdi.sortRoomsBy(session, "Free", "coast")) {
			System.out.println(room.getCoast());
		}
		
	}
}
