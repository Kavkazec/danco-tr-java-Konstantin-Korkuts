package com.danco.training.util;

import java.util.List;

import com.danco.training.entity.Service;


public class PrintService {
	private static final String SEPAR = " ; ";
	
	public static void printServices(List<Service> list){
		for (Service service : list) {
			StringBuilder sb = new StringBuilder();
			sb.append(service.getId());
			sb.append(SEPAR);
			sb.append(service.getName());
			sb.append(SEPAR);
			sb.append(service.getCoast());
			sb.append(SEPAR);
			sb.append(service.getSettlement().getId());
			sb.append(SEPAR);
			sb.append(service.getDate());
			sb.append(SEPAR);
			sb.append(service.getType());
			sb.append(SEPAR);
			InReader.print(sb.toString());
		}
	}
}
