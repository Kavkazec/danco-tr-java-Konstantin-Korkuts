package com.danco.training.transaction;

import java.sql.Connection;

import com.danco.training.persistexception.PersistenceException;

public interface TransactionDao {
	public Connection getConnection() throws PersistenceException;
    
    public void begin() throws PersistenceException;

    public void commit() throws PersistenceException;

    public void rollback() throws PersistenceException;
}
