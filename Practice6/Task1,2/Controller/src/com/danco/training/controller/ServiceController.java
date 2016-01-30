package com.danco.training.controller;

import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InService;
import com.danco.training.controller.utils.PrintService;
import com.danco.training.service.HotelService;

public class ServiceController {
	private HotelService service;
	private InReader inReader;
	private InService inService;
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String LINE = "-------------------------------------------";
	private PrintService printService;
	
	public PrintService getPrintService() {
		if(printService == null){
			printService = new PrintService();
		}
		return printService;
	}
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
	}
	
	public void deleteService(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(getService().getServices());
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		getService().deleteService(name);
	}
	
	public void changeServicesCoast(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(getService().getServices());
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		getService().changeServicesCoast(name, coast);
	}
	
	public void printService(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(getService().getServices());
		getInReader().print(LINE);
	}
	
	public void exportServices(){
		getService().exportServices();
	}
	public void importServices(){
		getService().importServices();
	}
}
