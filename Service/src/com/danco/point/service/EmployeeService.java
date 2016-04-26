package com.danco.point.service;

import java.sql.Connection;
import java.util.List;

import com.danco.point.api.IEmployeeService;
import com.danco.point.dao.impl.EmployeeDaoImpl;
import com.danco.point.entity.Employee;
import com.danco.point.persistexception.PersistenceException;
import com.danco.point.properties.DBConnection;

public class EmployeeService implements IEmployeeService{
	private EmployeeDaoImpl dao = new EmployeeDaoImpl();
	
	public Connection getConnection() {
		try {
			return DBConnection.getInstance().getConnection();
		} catch (PersistenceException e) {
			return null;
		}
	}
	@Override
	public List<Employee> getEmployees() {
		try {
			return dao.getAll(getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void exportGuests(List<Employee> list) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void importGuests() {
		
	}

}
