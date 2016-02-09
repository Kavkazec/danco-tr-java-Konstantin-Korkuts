package com.danco.training.di;

import com.danco.training.properties.PropertiesReader;

public class DIConfig {
	
	private static DIConfig instance;
	
	public static DIConfig getInstance(){
		if(instance == null){
			instance = new DIConfig();
		}
		return instance;
	}
	
	private DIConfig(){
		PropertiesReader.getInstance().setProperties();
	}
	
	public String[] getClassName(){
		return PropertiesReader.getInstance().getUtil().getServName();
	}
}
