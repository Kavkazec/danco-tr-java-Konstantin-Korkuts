package com.danco.training.di;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class DependencyInjection {

	private final static Logger LOGGER = Logger.getLogger(DependencyInjection.class.getName());

	private static DependencyInjection instance;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public static DependencyInjection getInstance(){
		if(instance == null){
			instance = new DependencyInjection();
		}
		return instance;
	}

	public Object getClassInstance(Class<?> clazz) {
		Object obj = null;
		if (map.containsKey(clazz.getName())) {
			obj = map.get(clazz.getName());
		} else {
			String implClassName = DIConfig.getInstance().getImplClassName(clazz.getName());
			try {
				Class<?> implClass = Class.forName(implClassName);
				obj = implClass.newInstance();
				map.put(implClassName, obj);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return obj;
	}
}