package com.danco.training.Storage;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.Model.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceStorage.
 */
public class ServiceStorage{
	
	/** The services. */
	private List<ServiceModel> services = new ArrayList<ServiceModel>();
	
	/**
	 * Adds the service.
	 *
	 * @param service the service
	 */
	public void addService(ServiceModel service){
		services.add(service);
	}
	
	/**
	 * Gets the list of services.
	 *
	 * @return the list of services
	 */
	public List<ServiceModel> getListOfServices(){
		return services;
	}
	
	/** The instance. */
	private static ServiceStorage instance;

	/**
	 * Gets the single instance of ServiceStorage.
	 *
	 * @return single instance of ServiceStorage
	 */
	public static ServiceStorage getInstance() {
		if (instance == null) {
			instance = new ServiceStorage();
		}
		return instance;
	}
	
}
