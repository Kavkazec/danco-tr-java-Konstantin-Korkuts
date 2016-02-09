package com.danco.training.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import com.danco.training.annotation.ConfigPropery;

public class PropertisAnnot {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private String path;
	private String param;
	private String type;
	private List<String> listType;
	public void procAnnotation(String className){
		PropertiesReader.getInstance().setProperties();
		try {
			Class<?> cl = Class.forName(className);
			Field[] fields = cl.getDeclaredFields();
			for(int i = 0; i < fields.length; i++){
				if(fields[i].isAnnotationPresent(ConfigPropery.class)){
					ConfigPropery ann = fields[i].getAnnotation(ConfigPropery.class);
					path = ann.cPath();
					param = ann.param();
					type =ann.type();
					FileInputStream reader = new FileInputStream(path);
					Properties properties = new Properties();
					properties.load(reader);
					if(type.equals("int")){
						Integer.parseInt(properties.getProperty(param+"."+type));
					}
					if(type.equals("String")){
						properties.getProperty(param+"."+type);
					}
					
					if(type.equals("Date")){
						if(properties.getProperty(param+"."+type) != null){
							sdf.parse(properties.getProperty(param+"."+type));
						}
					}
					if(type.equals("list")){
						listType.add(properties.getProperty(param+"."+type));
					}
			
				}
				
			}	
		} catch (ClassNotFoundException | FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} catch (ParseException e) {
			e.getMessage();
		}
	}
}
