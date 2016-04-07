package com.danco.training.util;

import java.util.List;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Settlement;

public class PrintGuest {
	private static final String SEPAR = " ; ";
	public static void printGuests(List<Guest> list){
		for (Guest guest : list) {
			StringBuilder sb = new StringBuilder();
			sb.append(guest.getId());
			sb.append(SEPAR);
			sb.append(guest.getName());
			sb.append(SEPAR);
			sb.append(guest.getPassportSeries());
			sb.append(SEPAR);
			sb.append(guest.getPassportNumber());
			sb.append(SEPAR);
			for(Settlement settlement : guest.getSettlementList()){
				sb.append(settlement.getId());
				sb.append(SEPAR);
			}
			InReader.print(sb.toString());
		}
	}
}
