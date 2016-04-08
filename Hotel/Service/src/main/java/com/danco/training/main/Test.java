package com.danco.training.main;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.danco.training.api.IRoomDao;
import com.danco.training.daoimpl.SettlementDaoImpl;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Service;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.properties.HibernateUtil;
import com.danco.training.service.GuestService;
import com.danco.training.service.RoomService;
import com.danco.training.service.ServiceService;
import com.danco.training.service.SettlementService;

public class Test {
	public static void main(String[] args) throws PersistenceException{
		SettlementService ss = new SettlementService();
		List<String> str= ss.servicesAndRoomsPriceSortedBy("");
		Collections.sort(str);
		for (String string : str) {
			System.out.println(string);
		}
		
		
	}
}
