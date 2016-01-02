package com.danco.training.Service;


import com.danco.training.Model.ServiceModel;
import com.danco.training.Storage.Hotel;

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
