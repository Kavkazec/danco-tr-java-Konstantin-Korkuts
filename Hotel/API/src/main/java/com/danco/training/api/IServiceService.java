package com.danco.training.api;

import java.util.List;

import com.danco.training.entity.Service;

public interface IServiceService {
	public Service getByIdService(int id);
	public void addService(Service service);
	public void deleteService(Service service);
	public void updateService(Service service);
	public List<Service> getServices();
	public void changeServiceCoast(Service service);
	public void exportServices();
	public void importServices();
}
