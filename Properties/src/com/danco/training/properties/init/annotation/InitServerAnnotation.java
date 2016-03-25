package com.danco.training.properties.init.annotation;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.Service;

public class InitServerAnnotation {
	private static final String ZAP =";";
	@ConfigPropery(cPath = "config.annot", param = "Service.name", type = "String")
	private String name;
	@ConfigPropery(cPath = "config.annot", param = "Service.coast", type = "int")
	private int coast;
	@ConfigPropery(cPath = "config.annot", param = "Service.serviceList", type = "List")
	private List<String> serviceList = new ArrayList<String>();
	private List<Service> list;
	
	public List<Service> buildServices(){
		list = new ArrayList<Service>();
		list.add(new Service(name, coast));
		for(int i = 0; i < serviceList.size(); i++){
			String[] str = serviceList.get(i).split(ZAP);
			String name = str[0];
			int coast = Integer.parseInt(str[1]);
			Service sm = new Service(name, coast);
			list.add(sm);
		}
		return list;
	}
}
