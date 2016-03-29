package com.danco.training.persistexception;

public class PersistenceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8851856144272002809L;
	
	public PersistenceException() {
		super();
	}

	public PersistenceException(String msg) {
        super(msg);
    }

	public PersistenceException(Exception exception) {
		super(exception);
	}
}
