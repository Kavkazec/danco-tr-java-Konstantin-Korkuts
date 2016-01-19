package com.danco.training.storage;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceStorage.
 */
public class ServiceStorage{
	
	/** The services. */
	private List<ServiceModel> services;
	
	/**
	 * Adds the service.
	 *
	 * @param service the service
	 */
	public void addService(ServiceModel service){
		services.add(service);
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(ServiceModel service){
		if(services.contains(service)){
			services.remove(service);
		}
	}
	
	/**
	 * Gets the list of services.
	 *
	 * @return the list of services
	 */
	public List<ServiceModel> getListOfServices(){
		if(services == null){
			services = new ArrayList<ServiceModel>();
		}
		return services;
	}
}
