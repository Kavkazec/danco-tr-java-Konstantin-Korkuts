package com.danco.training.controller.utils;

import com.danco.training.model.ServiceModel;

public class InService {
	public ServiceModel inputService(){
		InReader input = new InReader();
		input.print("Name:");
		String name = input.readStrin();
		input.print("Coast:");
		int coast = input.readInt();	
		return new ServiceModel(name, coast);
	}
}
