package com.danco.training.model;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceModel.
 */
public class ServiceModel {

	/** The name. */
	private String name;

	/** The coast. */
	private int coast;

	/** The date. */
	private Date date;

	/** The Constant SEMICOLON. */
	private static final String SEMICOLON = " ; ";

	/**
	 * Instantiates a new service model.
	 *
	 * @param name
	 *            the name
	 * @param coast
	 *            the coast
	 * @param date
	 *            the date
	 */
	public ServiceModel(String name, int coast) {
		this.name = name;
		this.coast = coast;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the coast.
	 *
	 * @return the coast
	 */
	public int getCoast() {
		return coast;
	}

	/**
	 * Sets the coast.
	 *
	 * @param coast
	 *            the new coast
	 */
	public void setCoast(int coast) {
		this.coast = coast;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + SEMICOLON);
		sb.append(Integer.toString(getCoast()) + SEMICOLON);
		return sb.toString();
	}

}
