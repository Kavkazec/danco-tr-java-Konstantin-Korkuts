package com.danco.training.view.util;

import java.util.List;

import com.danco.training.entity.ServiceModel;


public class PrintService {
	private static final String SEPAR = " ; ";
	
	public static void printServices(List<ServiceModel> list){
		for(int i = 0; i < list.size(); i++){
			InReader.print(list.get(i).getName() + SEPAR + list.get(i).getCoast() 
						+ SEPAR);
		}
	}
}
