package com.danco.training.di;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class DependencyInjection {
	private static final Logger LOGGER = Logger.getLogger(DependencyInjection.class);
	private static DependencyInjection instance;

	public static DependencyInjection getInstance() {
		if (instance == null) {
			instance = new DependencyInjection();
		}
		return instance;
	}

	private DependencyInjection() {

	}

	private Map<String, Object> map = new HashMap<String, Object>();

	public Object getClassInstance(Class<?> clazz) {
		String[] className = DIConfig.getInstance().getClassName();
		Object ob = null;
		for (int i = 0; i < className.length; i++) {
			if (!map.containsKey(className[i])){
				try {
					Class<?> cl = Class.forName(className[i]);
					map.put(className[i], cl.newInstance());
				} catch (ClassNotFoundException e) {
					LOGGER.error(e.getMessage(),e);
				} catch (InstantiationException e) {
					LOGGER.error(e.getMessage(),e);
				} catch (IllegalAccessException e) {
					LOGGER.error(e.getMessage(),e);
				}
			} 	
			
		}
		
		for(Map.Entry<String, Object> uu: map.entrySet()){
			for(int i = 0; i < uu.getValue().getClass().getInterfaces().length; i++){
				if(uu.getValue().getClass().getInterfaces()[i].getName().equals(clazz.getName())){
					ob = uu.getValue();
				}
			}
		}
		return ob;
	}
}