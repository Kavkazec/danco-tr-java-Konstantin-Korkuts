package com.danco.training.Storage;

import java.util.ArrayList;

import com.danco.training.Model.ServiceModel;

public class ServiceStorage{
	private ArrayList<ServiceModel> services = new ArrayList<ServiceModel>();
	public void addService(ServiceModel service){
		services.add(service);
	}
	public ArrayList<ServiceModel> getListOfServices(){
		return services;
	}
	
	private static ServiceStorage instance;

	public static ServiceStorage getInstance() {
		if (instance == null) {
			instance = new ServiceStorage();
		}
		return instance;
	}
	
}
