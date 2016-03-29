package com.danco.training.service;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IServiceDao;
import com.danco.training.api.IServiceService;
import com.danco.training.api.ISettlementService;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Service;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceService.
 */
public class ServiceService implements IServiceService{
	private static final Logger LOGGER = Logger.getLogger(ServiceService.class);
	private ImportAndExport ie = ImportAndExport.getInstance();
	private IServiceDao dao = (IServiceDao) DependencyInjection.getInstance().getClassInstance(IServiceDao.class);

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

	public void addService(Service service) {
		try {
			dao.add(getConnection(), service);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void deleteService(Service service) {
		try {
			dao.delete(getConnection(), service);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public List<Service> getServices() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	public void exportServices() {
		try {
			ie.writeToFileServices(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void importServices() {
		try {
			ie.readFromFileServices(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void buildServicesFromAnnot() {
		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void updateService(Service service) {
		try {
			dao.update(getConnection(), service);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void changeServiceCoast(Service service) {
		try {
			dao.update(getConnection(), service);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public Service getByIdService(int id) {
		try {
			return dao.getById(getConnection(), id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

}
