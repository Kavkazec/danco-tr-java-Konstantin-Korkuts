package com.danco.training.controller.utils;

import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.training.model.ServiceModel;
import com.danco.training.service.ServiceService;


public class PrintService {
	private static final String SEPAR = " ; ";
	private InReader reader = new InReader();
	private ServiceService serv;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public ServiceService getServ() {
		return serv;
	}
	public void printServices(List<ServiceModel> list){
		for(int i = 0; i < list.size(); i++){
				reader.print(list.get(i).getName() + SEPAR + list.get(i).getCoast() 
						+ SEPAR);
		}
	}
}
