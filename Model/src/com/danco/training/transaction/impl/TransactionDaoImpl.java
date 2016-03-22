package com.danco.training.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.transaction.TransactionDao;

public class TransactionDaoImpl implements TransactionDao {
	private static TransactionDaoImpl instance = null;
    private Connection connection = null;
    
    private TransactionDaoImpl() {
        
    }
    
    public static TransactionDaoImpl getInstance() {
        if(instance == null) {
        	instance = new TransactionDaoImpl();
        }
        return instance;
    }
    
    public Connection getConnection() throws PersistenceException {
        try {
            if(connection == null || connection.isClosed()) {
                connection = ConnectionProvider.getInstance().getConnection();
            } 
        } catch(SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return connection;
    }
    
    public void begin() throws PersistenceException {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
    }

    public void commit() throws PersistenceException {
        try {
            connection.commit();
        } catch (SQLException sqlCommitException) {
            throw new PersistenceException(sqlCommitException);
        } finally {
            close();
        }
    }

    public void rollback() throws PersistenceException {
        try {
            connection.rollback();
        } catch (SQLException sqlRollbackException) {
            throw new PersistenceException(sqlRollbackException);
        } finally {
            close();
        }
    }
    
    private void close() throws PersistenceException {
        try {
            if(connection != null && 
               !connection.isClosed()) {
                ConnectionProvider.getInstance().closeConnection();
                connection = null;
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
    }
}
