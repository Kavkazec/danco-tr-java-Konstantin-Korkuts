package com.danco.training.util;

import java.util.List;

import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public class PrintSettlement {
	private static final String SEPAR = " ; ";

	public static void printSettlement(List<Settlement> list) {
		for (Settlement settlement : list) {
			StringBuilder sb = new StringBuilder();
			sb.append(settlement.getId());
			sb.append(SEPAR);
			sb.append(settlement.getRoom().getNumber());
			sb.append(SEPAR);
			sb.append(settlement.getGuest().getName());
			sb.append(SEPAR);
			for (Service service : settlement.getServiceList()) {
				sb.append(service.getName());
				sb.append(SEPAR);
			}
			sb.append(settlement.getDateOfArrival());
			sb.append(SEPAR);
			sb.append(settlement.getDateOfDeparture());
			sb.append(SEPAR);
			sb.append(settlement.isPaid());
			sb.append(SEPAR);
			InReader.print(sb.toString());

		}
	}
}
