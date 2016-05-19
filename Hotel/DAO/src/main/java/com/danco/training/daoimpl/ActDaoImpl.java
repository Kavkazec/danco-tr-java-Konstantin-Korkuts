package com.danco.training.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

import com.danco.training.api.IActDao;
import com.danco.training.entity.Act;
import com.danco.training.persisexception.PersistenceException;

public class ActDaoImpl extends AbstractDaoImpl<Act> implements IActDao {

	public ActDaoImpl() {
		super(Act.class);
	}

	@SuppressWarnings("unchecked")
	public List<Act> getAll(Session session) throws PersistenceException {
		List<Act> acts = null;
		try {
			Criteria empQuery = session.createCriteria(Act.class)
					.setFetchMode("user", FetchMode.JOIN);
			acts = empQuery.list();
		} catch (Exception e) {
			 throw new PersistenceException(e);
		} 
		return acts;
	}

}
