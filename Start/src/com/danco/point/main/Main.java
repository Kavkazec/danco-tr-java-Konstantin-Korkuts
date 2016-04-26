package com.danco.point.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.danco.point.dao.impl.EmployeeDaoImpl;
import com.danco.point.entity.Employee;
import com.danco.point.persistexception.PersistenceException;
import com.danco.point.properties.DBConnection;

public class Main {

	public static void main(String[] args) throws PersistenceException, SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DBConnection db = DBConnection.getInstance();
		Date date = sdf.parse("2016-04-19");
		Employee employee = new Employee("Kostya", "Koruts", date, "M", "QA");
		String sql = "INSERT INTO employee (f_name, l_name,b_date,gender,tittle) VALUES (?,?,?,?,?);";
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		statement.setString(1, employee.getFirstName());
		statement.setString(2, employee.getLastName());
		java.sql.Date dd = new java.sql.Date(employee.getbDate().getTime());
		statement.setDate(3, dd);
		statement.setObject(4, employee.getGender());
		statement.setString(5, employee.getTittle());
		statement.executeUpdate();
		
		EmployeeDaoImpl ee = new EmployeeDaoImpl();
		for (Employee string : ee.getAll(db.getConnection())) {
			System.out.println(string.getFirstName());
		}
	}

}
