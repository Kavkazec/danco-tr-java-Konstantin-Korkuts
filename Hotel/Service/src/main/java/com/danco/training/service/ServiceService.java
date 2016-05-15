package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IServiceDao;
import com.danco.training.api.IServiceService;
import com.danco.training.daoimpl.ServiceDaoImpl;
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
	//private IServiceDao dao = (IServiceDao) DependencyInjection.getInstance().getClassInstance(IServiceDao.class);
	private IServiceDao dao = new ServiceDaoImpl();
	
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
			session.beginTransaction();
			dao.add(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
			session.beginTransaction();
			dao.delete(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Service> getServices() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Service> services = null;
		try {
			session.beginTransaction();
			services = dao.getAll(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return services;
	}

	public void exportServices() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.writeToFileServices(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void importServices() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.readFromFileServices(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void updateService(Service service) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
			session.beginTransaction();
			dao.update(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public Service getByIdService(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Service service = null;
		try {
			session.beginTransaction();
			service = dao.getById(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return service;
	}
}
