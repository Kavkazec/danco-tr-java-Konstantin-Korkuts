package com.danco.training.service;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IGuestService;
import com.danco.training.api.ISettlementService;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */

public class GuestService implements IGuestService{
	private static final Logger LOGGER = Logger.getLogger(GuestService.class);
	private ImportAndExport ie = ImportAndExport.getInstance();
	private IGuestDao dao = (IGuestDao) DependencyInjection.getInstance().getClassInstance(IGuestDao.class);
	
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

	public void addGuest(Guest guest) {
		try {
			dao.add(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void deleteGuest(Guest guest) {
		try {
			dao.delete(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void updateGuest(Guest guest) {
		try {
			dao.update(getConnection(), guest);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public List<Guest> getGuests() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public void exportGuests() {
		try {
			ie.writeToFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void importGuests() {
		try {
			ie.readFromFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void buildGuestsFromAnnot() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public int numberOfGuests() {
		try {
			return dao.getAll(getConnection()).size();
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		}
	}

	public Guest getByIdGuest(int id) {
		try {
			return dao.getById(getConnection(), id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

}
