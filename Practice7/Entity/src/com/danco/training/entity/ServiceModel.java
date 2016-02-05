package com.danco.training.entity;

import java.io.Serializable;
import java.util.Date;

import com.danco.training.annotation.ConfigPropery;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceModel.
 */
public class ServiceModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722992019180708232L;

	/** The name. */
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.name", type = "String")
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	/** The coast. */
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.coast", type = "int")
	private int coast;

	/** The date. */
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.date", type = "Date")
	private Date date;

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
}
