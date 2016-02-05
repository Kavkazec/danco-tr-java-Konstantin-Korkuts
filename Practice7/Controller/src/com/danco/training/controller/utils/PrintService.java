package com.danco.training.controller.utils;

import java.util.List;

import com.danco.training.entity.ServiceModel;


public class PrintService {
	private static final String SEPAR = " ; ";
	private InReader reader = new InReader();
	
	public void printServices(List<ServiceModel> list){
		for(int i = 0; i < list.size(); i++){
				reader.print(list.get(i).getName() + SEPAR + list.get(i).getCoast() 
						+ SEPAR);
		}
	}
}
