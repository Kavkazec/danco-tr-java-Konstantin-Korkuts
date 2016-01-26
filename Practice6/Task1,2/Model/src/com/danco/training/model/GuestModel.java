package com.danco.training.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestModel.
 */
public class GuestModel implements Serializable {
	
	private static final long serialVersionUID = -4853470731812061052L;

	/** The name. */
	private String name;
	
	/** The date of add. */
	private Date dateOfAdd;
    
    /** The date of evi. */
    private Date dateOfEvi;
    
    /** The Constant SEMICOLON. */
    private static final String SEMICOLON = " ; ";
    
    /** The sdf. */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/** The services. */
	private List<ServiceModel> services = new ArrayList<ServiceModel>();
	
	/**
	 * Instantiates a new guest model.
	 *
	 * @param name the name
	 * @param dateOfAdd the date of add
	 * @param dateOfEvi the date of evi
	 */
	public GuestModel(String name, Date dateOfAdd, Date dateOfEvi){
		this.name = name;
		this.dateOfAdd = dateOfAdd;
		this.dateOfEvi = dateOfEvi;
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
	 * Gets the date of add.
	 *
	 * @return the date of add
	 */
	public Date getDateOfAdd() {
		return dateOfAdd;
	}
	
	
	/**
	 * Sets the date add.
	 *
	 * @param dateOfAdd the new date add
	 */
	public void setDateAdd(Date dateOfAdd){
		this.dateOfAdd = dateOfAdd;
	}
	
	/**
	 * Gets the date of evi.
	 *
	 * @return the date of evi
	 */
	public Date getDateOfEvi() {
		return dateOfEvi;
	}
	
	/**
	 * Sets the date evi.
	 *
	 * @param dateOfEvi the new date evi
	 */
	public void setDateEvi(Date dateOfEvi){
		this.dateOfEvi = dateOfEvi;
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<ServiceModel> getServices() {
		return services;
	}
	
	/**
	 * Sets the services.
	 *
	 * @param services the new services
	 */
	public void setServices(ServiceModel services) {
		this.services.add(services);
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+SEMICOLON);
		sb.append(sdf.format(getDateOfAdd())+SEMICOLON);
		sb.append(sdf.format(getDateOfEvi())+SEMICOLON);	
		return sb.toString();
	}
}
