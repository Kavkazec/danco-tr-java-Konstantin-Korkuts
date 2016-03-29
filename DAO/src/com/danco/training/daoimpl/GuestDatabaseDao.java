package com.danco.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.api.IGuestDao;
import com.danco.training.entity.Guest;
import com.danco.training.persistexception.PersistenceException;

public class GuestDatabaseDao implements IGuestDao{
	private static final String PARSE_EXCEPTION = "ParseException";
	private static GuestDatabaseDao instance;
	public static GuestDatabaseDao getInsatnce(){
		if(instance == null){
			instance = new GuestDatabaseDao();
		}
		return instance;
	}
	
	public Guest getById(Connection connection, int id) throws PersistenceException{
		ResultSet result = null;
		Guest guest = null;
		try{
			String sql = "SELECT * FROM guest_model WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while(result.next()){
				guest = parserRS(result);
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return guest;
	}

	@Override
	public List<Guest> getAll(Connection connection) throws PersistenceException{
		ResultSet result = null;
		List<Guest> guestsList = new ArrayList<Guest>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM guest_model;");
			while(result.next()){
				guestsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return guestsList;
	}

	@Override
	public void delete(Connection connection, Guest model) throws PersistenceException{
		try{
			String sql = "DELETE FROM guest_model WHERE Id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getId());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void update(Connection connection, Guest model) throws PersistenceException{
		try{
			String sql = "UPDATE guest_model SET guest_name=?, passport_series=?, passport_number=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getPassportSeries());
			statement.setInt(3, model.getPassportNumber());
			statement.setInt(4, model.getId());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void add(Connection connection, Guest model) throws PersistenceException{
		try{
			String sql = "INSERT INTO guest_model (guest_name, passport_series, passport_number) VALUES (?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getPassportSeries());
			statement.setInt(3, model.getPassportNumber());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public Guest parserRS(ResultSet result) throws PersistenceException {
		Guest guest = null;
		try{
				int id = result.getInt("Id");
				String name = result.getString("guest_name");
				String passport_series = result.getString("passport_series");
				int passport_number = result.getInt("passport_number");
				guest = new Guest(id, name, passport_series, passport_number);
			
		} catch(Exception ex) {
			 throw new PersistenceException(PARSE_EXCEPTION);
		}
		return guest;
	}

}
