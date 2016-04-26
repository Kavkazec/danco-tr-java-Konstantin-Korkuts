package com.danco.point.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.point.api.IEmployeeDAO;
import com.danco.point.entity.Employee;
import com.danco.point.persistexception.PersistenceException;

public class EmployeeDaoImpl implements IEmployeeDAO {

	@Override
	public List<Employee> getAll(Connection connection) throws PersistenceException {
		ResultSet result = null;
		List<Employee> guestsList = new ArrayList<Employee>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM employee;");
			while(result.next()){
				guestsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return guestsList;
	}

	@Override
	public void add(Connection connection, Employee model) throws PersistenceException {
		try{
			String sql = "INSERT INTO employee (f_name, l_name,b_date,gender,tittle) VALUES (?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getFirstName());
			statement.setString(2, model.getLastName());
			java.sql.Date dd = new java.sql.Date(model.getbDate().getTime());
			statement.setDate(3, dd);
			statement.setObject(4, model.getGender());
			statement.setString(5, model.getTittle());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void update(Connection connection, Employee model) throws PersistenceException {
		try{
			String sql = "UPDATE employee SET f_name=?, l_name=?, b_date=?, gender=?, tittle=? WHERE id=? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getFirstName());
			statement.setString(2, model.getLastName());
			java.sql.Date dd = new java.sql.Date(model.getbDate().getTime());
			statement.setDate(3, dd);
			statement.setObject(4, model.getGender());
			statement.setString(5, model.getTittle());
			statement.setInt(6, model.getId());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public Employee parserRS(ResultSet result) throws PersistenceException {
		Employee employee = null;
		try{
				int id = result.getInt("id");
				String fName = result.getString("f_name");
				String lName = result.getString("l_name");
				Date date = result.getDate("b_date");
				String gender = result.getString("gender");
				String tittle = result.getString("tittle");
				employee = new Employee(id, fName, lName, date, gender, tittle);
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return employee;
	}
	
}
