package com.danco.training.controller.api;

import java.util.List;

import com.danco.training.model.ServiceModel;

public interface IServiceController {
	public void addService(ServiceModel service);
	public void deleteService(String name);
	public void changeServicesCoast(String name, int coast);
	public List<ServiceModel> printService();
	public void exportServices();
	public void importServices();
}
