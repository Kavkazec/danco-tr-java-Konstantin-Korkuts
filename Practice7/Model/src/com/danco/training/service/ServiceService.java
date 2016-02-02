package com.danco.training.service;


import java.util.List;

import com.danco.training.model.GuestModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.reader.ImportAndExport;
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
	
	public void exportServices(String path){
		ImportAndExport.getInstance().writeToFileServices(path);
	}
	
	public void importServices(String path){
		ImportAndExport.getInstance().readFromFileServices(path);
	}
}
