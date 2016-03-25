package com.danco.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.danco.training.dao.ServiceDao;
import com.danco.training.entity.Service;
import com.danco.training.persistexception.PersistenceException;

public class ServiceDatabaseDao implements ServiceDao{

	private static final String PARSE_EXCEPTION = "ParseException";
	private static ServiceDatabaseDao instance;
	
	private ServiceDatabaseDao(){
		
	}
	
	public static ServiceDatabaseDao getInstance(){
		if(instance == null){
			instance = new ServiceDatabaseDao();
		}
		return instance;
	}
	
	public Service getById(Connection connection, int id) throws PersistenceException{
		ResultSet result = null;
		Service service = null;
		try{
			String sql = "SELECT * FROM service_model WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while(result.next()){
				service = parserRS(result);
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return service;
	}

	@Override
	public List<Service> getAll(Connection connection) throws PersistenceException{
		ResultSet result = null;
		List<Service> servicesList = new ArrayList<Service>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM service_model;");
			while(result.next()){
				servicesList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return servicesList;
	}

	@Override
	public void delete(Connection connection, Service model) throws PersistenceException{
		try{
			String sql = "DELETE FROM room_model WHERE Id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getId());
			statement.executeUpdate();
			connection.commit();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void update(Connection connection, Service model) throws PersistenceException{
		try{
			String sql = "UPDATE service_model SET service_name=?, coast=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setInt(2, model.getCoast());
			statement.setInt(4, model.getId());
			statement.executeUpdate();
			connection.commit();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void add(Connection connection, Service model) throws PersistenceException{
		try{
			String sql = "INSERT INTO service_model (service_name, coast) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setInt(2, model.getCoast());
			statement.executeUpdate();
			connection.commit();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public Service parserRS(ResultSet result) throws PersistenceException {
		Service service = null;
		try{
				int id = result.getInt("Id");
				String name = result.getString("service_name");
				int coast = result.getInt("coast");
				service = new Service(id, name, coast);
			
		} catch(Exception ex) {
			 throw new PersistenceException(PARSE_EXCEPTION);
		}
		return service;
	}

}
