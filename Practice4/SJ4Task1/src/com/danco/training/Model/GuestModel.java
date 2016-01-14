package com.danco.training.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestModel.
 */
public class GuestModel  {
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The date of add. */
	private Date dateOfAdd;
    
    /** The date of evi. */
    private Date dateOfEvi;
    
    /** The Constant SEMICOLON. */
    private static final String SEMICOLON = " ; ";
    
    /** The sdf. */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/** The services. */
	private List<ServiceModel> services = new ArrayList<ServiceModel>();
	
	/**
	 * Instantiates a new guest model.
	 *
	 * @param id the id
	 * @param name the name
	 * @param dateOfAdd the date of add
	 * @param dateOfEvi the date of evi
	 */
	public GuestModel(int id, String name, GregorianCalendar dateOfAdd, GregorianCalendar dateOfEvi){
		this.id = id;
		this.name = name;
		this.dateOfAdd = dateOfAdd.getTime();
		this.dateOfEvi = dateOfEvi.getTime();
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
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId(){
		return id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(getId())+SEMICOLON);
		sb.append(getName()+SEMICOLON);
		sb.append(sdf.format(getDateOfAdd())+SEMICOLON);
		sb.append(sdf.format(getDateOfEvi())+SEMICOLON);	
		return sb.toString();
	}
}
