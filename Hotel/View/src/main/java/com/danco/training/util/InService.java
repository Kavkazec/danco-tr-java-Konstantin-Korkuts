package com.danco.training.util;

import com.danco.training.entity.Service;

public class InService {
	private static final String ID2 = "ID:";
	private static final String COAST2 = "Coast:";
	private static final String NAME2 = "Name:";

	public static Service inputService(){
		InReader.print(NAME2);
		String name = InReader.readStrin();
		InReader.print(COAST2);
		int coast = InReader.readInt();
		Service sm = new Service(name, coast);
		return sm;
	}
	
	public static Service inputServiceWithID(){
		InReader.print(ID2);
		int id = InReader.readInt();
		InReader.print(NAME2);
		String name = InReader.readStrin();
		InReader.print(COAST2);
		int coast = InReader.readInt();
		Service sm = new Service(id, name, coast);
		return sm;
	}
}
