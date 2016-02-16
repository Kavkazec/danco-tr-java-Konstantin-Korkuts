package com.danco.training.view.util;

import com.danco.training.entity.ServiceModel;

public class InService {
	public static ServiceModel inputService(){
		InReader.print("Name:");
		String name = InReader.readStrin();
		InReader.print("Coast:");
		int coast = InReader.readInt();
		ServiceModel sm = new ServiceModel(name, coast);
		return sm;
	}
}
