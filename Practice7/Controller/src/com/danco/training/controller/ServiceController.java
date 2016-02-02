package com.danco.training.controller;

import com.danco.training.controller.api.IServiceController;
import com.danco.training.controller.utils.InReader;
import com.danco.training.controller.utils.InService;
import com.danco.training.controller.utils.PrintService;

public class ServiceController {
	private InReader inReader;
	private InService inService;
	private static final String DETAILS_SERVICE = "name ; coast ;";
	private static final String LINE = "-------------------------------------------";
	private PrintService printService;
	private IServiceController serviceCon;
	
	
	public ServiceController(IServiceController serviceCon){
		this.serviceCon = serviceCon;
	}
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
	public InService getInService() {
		if(inService == null){
			inService = new InService();
		}
		return inService;
	}
	
	public void addService(){
		this.serviceCon.addService(getInService().inputService());
	}
	
	public void deleteService(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(this.serviceCon.printService());
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		this.serviceCon.deleteService(name);
	}
	
	public void changeServicesCoast(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(this.serviceCon.printService());
		getInReader().print(LINE);
		getInReader().print("Service name:");
		String name = getInReader().readStrin();
		getInReader().print("Coast:");
		int coast = getInReader().readInt();
		this.serviceCon.changeServicesCoast(name, coast);
	}
	
	public void printService(){
		getInReader().print(DETAILS_SERVICE);
		getPrintService().printServices(this.serviceCon.printService());
		getInReader().print(LINE);
	}
	
	public void exportServices(){
		this.serviceCon.exportServices();
	}
	public void importServices(){
		this.serviceCon.importServices();
	}
}
