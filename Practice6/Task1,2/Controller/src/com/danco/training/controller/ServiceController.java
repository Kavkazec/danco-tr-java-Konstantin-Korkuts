package com.danco.training.controller;

import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InService;
import com.danco.training.service.HotelService;

public class ServiceController {
	private HotelService service;
	private InReader inReader;
	private InService inService;
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String LINE = "-------------------------------------------";
	private static final String LINE_AFTER_ACTION = "#############################################";

	
	
	public InReader getInReader() {
		if(inReader == null){
			inReader = new InReader();
		}
		return inReader;
	}
	
	public HotelService getService() {
		if(service == null){
			service = HotelService.getInstance();
		}
		return service;
	}
	
	public InService getInService() {
		if(inService == null){
			inService = new InService();
		}
		return inService;
	}
	
	public void addService(){
		getService().addService(getInService().inputService());
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void deleteService(){
		getInReader().print(DETAILS_SERVICE);
		for(int i = 0; i < getService().getServices().size(); i++){
			getInReader().print(getService().getServices().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		getService().deleteService(name);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void changeServicesCoast(){
		getInReader().print(DETAILS_SERVICE);
		for(int i = 0; i < getService().getServices().size(); i++){
			getInReader().print(getService().getServices().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		getService().changeServicesCoast(name, coast);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void printService(){
		getInReader().print(DETAILS_SERVICE);
		for(int i = 0; i < getService().getServices().size(); i++){
			getInReader().print(getService().getServices().get(i).toString());
		}
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void writeServices(){ 
		 getService().writeServices();
		 getInReader().print(LINE_AFTER_ACTION);
	}
	
	public void showServicesFromFile(){
		getInReader().print(DETAILS_SERVICE);
		getInReader().print(getService().showServicesFromFile());
		getInReader().print(LINE);
		getInReader().print(LINE_AFTER_ACTION);
	}
}
