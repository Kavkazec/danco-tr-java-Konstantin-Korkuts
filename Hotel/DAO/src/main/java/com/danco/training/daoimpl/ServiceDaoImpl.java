package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.danco.training.api.IServiceDao;
import com.danco.training.entity.Service;
import com.danco.training.persisexception.PersistenceException;

public class ServiceDaoImpl implements IServiceDao{

	private static ServiceDaoImpl instance;
	public static ServiceDaoImpl getInsatnce(){
		if(instance == null){
			instance = new ServiceDaoImpl();
		}
		return instance;
	}
	@Override
	public Service getById(Session session, int id) throws PersistenceException {
		Service service = null;
		try {
			service = session.load(Service.class, id);
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return service;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Service> getAll(Session session) throws PersistenceException {
		List<Service> services = null;
		try {
			Criteria empQuery = session.createCriteria(Service.class);
			services = empQuery.list();
			for (Service emp : services) {
			    Hibernate.initialize(emp.getSettlement());
			}
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return services;
	}
	@Override
	public void add(Session session, Service model) throws PersistenceException {
		try {
			session.save(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
	@Override
	public void delete(Session session, Service model) throws PersistenceException {
		try {
			session.delete(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
	@Override
	public void update(Session session, Service model) throws PersistenceException {
		try {
			session.update(model);
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}
}
