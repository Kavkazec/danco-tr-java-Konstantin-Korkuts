package com.danco.training.server;

import java.io.Serializable;

public class Transmission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameOfMethod;
	private Object[] args;

	public Transmission(String nameOfMethod, Object[] args) {
		this.nameOfMethod = nameOfMethod;
		this.args = args;
	}

	public String getNameOfMethod() {
		return nameOfMethod;
	}

	public Object[] getArgs() {
		return args;
	}
}
