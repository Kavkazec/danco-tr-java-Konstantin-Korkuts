package com.danco.training.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestModel.
 */
public class GuestModel implements Serializable {
	
	private static final long serialVersionUID = -4853470731812061052L;

	/** The name. */
	@ConfigPropery(cPath = "config.annot", param = "GuestModel.name", type = "String")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

	public void setDateOfEvi(Date dateOfEvi) {
		this.dateOfEvi = dateOfEvi;
	}

	/** The date of add. */
	private Date dateOfAdd;
    
    /** The date of evi. */
    private Date dateOfEvi;
    
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
}
