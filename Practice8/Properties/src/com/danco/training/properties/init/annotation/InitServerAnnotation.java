package com.danco.training.properties.init.annotation;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.ServiceModel;

public class InitServerAnnotation {
	private static final String ZAP =";";
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.name", type = "String")
	private String name;
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.coast", type = "int")
	private int coast;
	@ConfigPropery(cPath = "config.annot", param = "ServiceModel.serviceList", type = "List")
	private List<String> serviceList = new ArrayList<String>();
	private List<ServiceModel> list;
	
	public List<ServiceModel> buildServices(){
		list = new ArrayList<ServiceModel>();
		list.add(new ServiceModel(name, coast));
		for(int i = 0; i < serviceList.size(); i++){
			String[] str = serviceList.get(i).split(ZAP);
			String name = str[0];
			int coast = Integer.parseInt(str[1]);
			ServiceModel sm = new ServiceModel(name, coast);
			list.add(sm);
		}
		return list;
	}
}
