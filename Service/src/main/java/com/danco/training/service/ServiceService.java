package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IServiceDao;
import com.danco.training.api.IServiceService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Service;
import com.danco.training.properties.HibernateUtil;
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

	public void addService(Service service) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.add(session, service);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void deleteService(Service service) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.delete(session, service);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Service> getServices() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getAll(session);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
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

	public void updateService(Service service) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.update(session, service);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void changeServiceCoast(Service service) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			dao.update(session, service);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public Service getByIdService(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getById(session, id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}
}
