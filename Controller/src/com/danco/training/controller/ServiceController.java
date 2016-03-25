package com.danco.training.controller;

import java.util.List;

import com.danco.training.entity.Service;
import com.danco.training.services.api.IServiceService;

public class ServiceController {
	private IServiceService serviceCon;
	
	
	public ServiceController(IServiceService serviceCon){
		this.serviceCon = serviceCon;
	}
	
	public Service getByIdService(int id) {
		return this.serviceCon.getByIdService(id);
		
	}
	
	public void addService(Service service){
		this.serviceCon.addService(service);
	}
	public void deleteService(Service service){
		this.serviceCon.deleteService(service);
	}
	public void updateService(Service service){
		this.serviceCon.updateService(service);
	}
	public List<Service> getServices(){
		return this.serviceCon.getServices();
	}
	public void changeServiceCoast(Service service){
		this.serviceCon.changeServiceCoast(service);
	}
	public void exportServices(){
		this.serviceCon.exportServices();
	}
	public void importServices(){
		this.serviceCon.importServices();
	}
	public void buildServicesFromAnnot(){
		this.serviceCon.buildServicesFromAnnot();
	}
}
