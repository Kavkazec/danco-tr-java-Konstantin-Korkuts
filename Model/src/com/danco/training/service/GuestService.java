package com.danco.training.service;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.dao.GuestDao;
import com.danco.training.dao.factory.DaoFactory;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.entity.Guest;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.services.api.IGuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */

public class GuestService implements IGuestService {
	private static final Logger LOGGER = Logger.getLogger(GuestService.class);
	private GuestDao dao = DaoFactory.getGuestDao();
	private ImportAndExport ie = ImportAndExport.getInstance();

	public String getPath() {
		try {
			PropertiesReader prop = PropertiesReader.getInstance();
			prop.setProperties();
			return prop.getUtil().getCsvPath();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public Connection getConnection() {
		try {
			return ConnectionProvider.getInstance().getConnection();
		} catch (PersistenceException e) {
			LOGGER.error(e);
			return null;

		}
	}

	@Override
	public void addGuest(Guest guest) {
		try {
			dao.add(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void deleteGuest(Guest guest) {
		try {
			dao.delete(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void updateGuest(Guest guest) {
		try {
			dao.update(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Guest> getGuests() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	@Override
	public void exportGuests() {
		try {
			ie.writeToFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void importGuests() {
		try {
			ie.readFromFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void buildGuestsFromAnnot() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public int numberOfGuests() {
		try{
			return dao.getAll(getConnection()).size();
		} catch(Exception e){
			LOGGER.error(e);
			return 0;
		}
	}

	@Override
	public Guest getByIdGuest(int id) {
		try{
			return dao.getById(getConnection(), id);
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

}
