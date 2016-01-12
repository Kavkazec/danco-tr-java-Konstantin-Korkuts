package com.danco.training.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceModel.
 */
public class ServiceModel{
	
	/** The name. */
	private String name;
	
	/** The coast. */
	private int coast;
	
	/** The date. */
	private Date date;
	
	/** The Constant SEMICOLON. */
	private static final char SEMICOLON = ';';
	
	/** The sdf. */
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Instantiates a new service model.
	 *
	 * @param name the name
	 * @param coast the coast
	 * @param date the date
	 */
	public ServiceModel(String name, int coast, GregorianCalendar date) {
		this.name = name;
		this.coast = coast;
		this.date = date.getTime();
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
	 * @param coast the new coast
	 */
	public void setCoast(int coast){
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name + SEMICOLON);
		sb.append(Integer.toString(coast) + SEMICOLON);
		sb.append(sdf.format(date).toString() + SEMICOLON);
		return sb.toString();
	}
	
}
