package com.danco.training.controller.utils;

import com.danco.training.entity.ServiceModel;

public class InService {
	public ServiceModel inputService(){
		InReader input = new InReader();
		input.print("Name:");
		String name = input.readStrin();
		input.print("Coast:");
		int coast = input.readInt();
		ServiceModel sm = new ServiceModel(name, coast);
		return sm;
	}
}
