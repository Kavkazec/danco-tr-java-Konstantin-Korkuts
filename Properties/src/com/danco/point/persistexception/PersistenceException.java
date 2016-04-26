package com.danco.point.persistexception;

public class PersistenceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4899396156889182707L;

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
