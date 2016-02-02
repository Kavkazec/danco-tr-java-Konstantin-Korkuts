package com.danco.training.di;

import java.util.HashMap;
import java.util.Map;

public class DependencyInjection {
	private static DependencyInjection instance;
	public static DependencyInjection getInstance(){
		if(instance == null){
			instance = new DependencyInjection();
		}
		return instance;
	}
	
	private DependencyInjection(){
		
	}
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	private void setObjectToMap(String className, Object ob){
		map.put(className, ob);
	}
	
	public Object getClassInstance(){
		String className = DIConfig.getInstance().getClassName();
		Object ob = null;
		if (map.containsKey(className)){
			ob = map.get(className);
		} else {
			try {
				Class cl = Class.forName(className);
				ob = cl.newInstance();
				setObjectToMap(className, ob);
			} catch (ClassNotFoundException e) {
				
			} catch (InstantiationException e) {
				
			} catch (IllegalAccessException e) {
				
			}
		}
		return ob;
	}
}