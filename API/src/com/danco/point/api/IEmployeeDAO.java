package com.danco.point.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.danco.point.entity.Employee;
import com.danco.point.persistexception.PersistenceException;

public interface IEmployeeDAO {
public List<Employee> getAll(Connection connection) throws PersistenceException;
	
	public void add(Connection connection, Employee model) throws PersistenceException;
	
	public void update(Connection connection, Employee model) throws PersistenceException;
	
	public Employee parserRS(ResultSet result) throws PersistenceException;
}
