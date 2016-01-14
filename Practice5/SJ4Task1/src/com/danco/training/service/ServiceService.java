package com.danco.training.service;


import com.danco.training.model.ServiceModel;
import com.danco.training.storage.Hotel;

	// TODO: Auto-generated Javadoc
/**
	 * The Class ServiceService.
	 */
	public class ServiceService {
	
	/** The hotel. */
	private Hotel hotel;
	
	/**
	 * Instantiates a new service service.
	 */
	public ServiceService(){
		hotel = Hotel.getInstance();
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
}
