package com.danco.point.properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.danco.point.persistexception.PersistenceException;

public class DBConnection {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static DBConnection instance;
	private static Connection connection = null;
	private static final String URL = "jdbc:mysql://localhost:3306/danco_point";
	private static final String USER = "root";
	private static final String PASSWORD = "d3dwq7zs";

	private DBConnection() throws PersistenceException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public static DBConnection getInstance() throws PersistenceException {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	public Connection getConnection() throws PersistenceException {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return connection;
	}

	public void closeConnection() throws PersistenceException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqlException) {
				throw new PersistenceException(sqlException);
			}
		}
	}
}
