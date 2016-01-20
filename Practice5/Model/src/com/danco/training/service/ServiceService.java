package com.danco.training.service;


import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.model.ServiceModel;
import com.danco.training.storage.Hotel;

	// TODO: Auto-generated Javadoc
/**
	 * The Class ServiceService.
	 */
	public class ServiceService {
		
	/** The hotel. */
	private Hotel hotel = Hotel.getInstance();
	
	/**
	 * Instantiates a new service service.
	 */
	
	/**
	 * Adds the service.
	 *
	 * @param service the service
	 */
	public void addService(ServiceModel service){
		hotel.addService(service);
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(String name){
		hotel.deleteService(name);
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<ServiceModel> getServices(){
		return hotel.getService().getListOfServices();
	}
	
	/**
	 * Change status.
	 *
	 * @param name the name
	 * @param coast the coast
	 */
	public void changeStatus(String name,int coast){	
		for(ServiceModel m: hotel.getService().getListOfServices()){
			if(m.getName() == name){
				m.setCoast(coast);
			}
		}	
	}
	
	/**
	 * Write services.
	 */
	
	public void writeServices(){
		hotel.writeServices();
	}
	
	/**
	 * Show services from file.
	 *
	 * @return the string
	 */
	
	public String showServicesFromFile(){
		return hotel.showServicesFromFile();
	}
	
}
