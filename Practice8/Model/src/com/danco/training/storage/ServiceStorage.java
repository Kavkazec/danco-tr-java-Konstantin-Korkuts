package com.danco.training.storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.danco.training.entity.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceStorage.
 */
public class ServiceStorage implements Serializable {
	private static final long serialVersionUID = 1L;

	public void setServices(List<ServiceModel> services) {
		HashSet<String> st;
		if (getListOfServices().isEmpty()) {
			st = new HashSet<String>();
			for (int j = 0; j < services.size(); j++) {
				st.add(services.get(j).getName());
				getListOfServices().add(services.get(j));
			}
		} else {
			st = new HashSet<String>();
			for (int j = 0; j < getListOfServices().size(); j++) {
				st.add(getListOfServices().get(j).getName());
			}
			for (int i = 0; i < services.size(); i++) {
				if(!st.contains(services.get(i).getName())){
					st.add(services.get(i).getName());
					getListOfServices().add(services.get(i));
				}
			}
		}
	}

	/** The services. */
	private List<ServiceModel> services;

	/**
	 * Adds the service.
	 *
	 * @param service
	 *            the service
	 */
	public void addService(ServiceModel service) {
		getListOfServices().add(service);
	}

	/**
	 * Delete service.
	 *
	 * @param service
	 *            the service
	 */
	public void deleteService(String name) {
		for (int i = 0; i < getListOfServices().size(); i++) {
			if (name.equals(getListOfServices().get(i).getName())) {
				getListOfServices().remove(i);
			}
		}
	}

	/**
	 * Gets the list of services.
	 *
	 * @return the list of services
	 */
	public List<ServiceModel> getListOfServices() {
		if (services == null) {
			services = new ArrayList<ServiceModel>();
		}
		return services;
	}

}
