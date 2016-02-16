package com.danco.training.controller;

import java.util.Collections;
import java.util.List;

import com.danco.training.controller.api.IServiceService;
import com.danco.training.entity.ServiceModel;

public class ServiceController {
	private IServiceService serviceCon;
	
	
	public ServiceController(IServiceService serviceCon){
		this.serviceCon = serviceCon;
	}
	
	public void addService(ServiceModel service){
		this.serviceCon.addService(service);
	}
	
	public void deleteService(String name){
		this.serviceCon.deleteService(name);
	}
	
	public void changeServicesCoast(String name, int coast){
		this.serviceCon.changeServicesCoast(name, coast);
	}
	
	public List<ServiceModel> printService(){
		return Collections.synchronizedList(this.serviceCon.printService());
	}
	
	public synchronized void exportServices(){
		this.serviceCon.exportServices();
	}
	public synchronized void importServices(){
		this.serviceCon.importServices();
	}
	
	public synchronized void buildServicesFromAnnot(){
		this.serviceCon.buildServicesFromAnnot();
	}
}
