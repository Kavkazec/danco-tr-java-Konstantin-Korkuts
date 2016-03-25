package com.danco.training.view.util;

import java.util.List;

import com.danco.training.entity.Service;


public class PrintService {
	private static final String SEPAR = " ; ";
	
	public static void printServices(List<Service> list){
		for (Service service : list) {
			InReader.print(service.getId() + SEPAR + service.getName() + SEPAR + service.getCoast());
		}
	}
}
