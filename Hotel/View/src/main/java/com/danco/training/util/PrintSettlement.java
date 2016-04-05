package com.danco.training.util;

import java.util.List;

import com.danco.training.entity.Settlement;

public class PrintSettlement {
	private static final String SEPAR = " ; ";
	
	public static void printSettlement(List<Settlement> list){
		for (Settlement settlement : list) {
			if(settlement.getService() == null){
				InReader.print(settlement.getId() + SEPAR + settlement.getRoom().getNumber() + SEPAR + settlement.getGuest().getName()
						 + SEPAR  + settlement.getDateOfArrival() 
						 + SEPAR + settlement.getDateOfDeparture()
						 + SEPAR + settlement.isPaid() );
			} else {
				InReader.print(settlement.getId() + SEPAR + settlement.getRoom().getNumber() + SEPAR + settlement.getGuest().getName()
						 + SEPAR + settlement.getService().getName() + SEPAR  + settlement.getDateOfArrival() 
						 + SEPAR + settlement.getDateOfDeparture() + SEPAR + settlement.getServiceDateOfAdd()  
						 + SEPAR + settlement.isPaid() );
			}
		}
	}
}
