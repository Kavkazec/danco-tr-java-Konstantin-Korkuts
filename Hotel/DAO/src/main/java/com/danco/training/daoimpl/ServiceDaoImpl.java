package com.danco.training.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

import com.danco.training.api.IServiceDao;
import com.danco.training.entity.Service;
import com.danco.training.persisexception.PersistenceException;

public class ServiceDaoImpl extends AbstractDaoImpl<Service> implements IServiceDao{
	public ServiceDaoImpl(){
		super(Service.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Service> getAll(Session session) throws PersistenceException {
		List<Service> services = null;
		try {
			Criteria empQuery = session.createCriteria(Service.class).setFetchMode("settlement", FetchMode.JOIN);
			services = empQuery.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return services;
	}
}
