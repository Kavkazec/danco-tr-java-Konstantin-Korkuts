package com.danco.training.annotation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ProcessAnnotation {
	private static final Logger LOGGER = Logger.getLogger(ProcessAnnotation.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final String ZAP = ",";
	private String path;
	private String param;
	private String type;
	private List<String> listType = new ArrayList<String>();

	public void procAnnotation(Object ob) {
		FileInputStream reader = null;
		try {
			Class<?> cl = ob.getClass();
			Field[] fields = cl.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].isAnnotationPresent(ConfigPropery.class)) {
					fields[i].setAccessible(true);
					ConfigPropery ann = fields[i].getAnnotation(ConfigPropery.class);
					path = ann.cPath();
					param = ann.param();
					type = ann.type();
					reader = new FileInputStream(path);
					Properties properties = new Properties();
					properties.load(reader);
					if(type.equals("int")){
						fields[i].set(ob, Integer.parseInt(properties.getProperty(param+"."+type)));
					}
					if(type.equals("String")){
						fields[i].set(ob, properties.getProperty(param+"."+type));
					}
					if(type.equals("Boolean")){
						fields[i].set(ob, properties.getProperty(param+"."+type));
					}
					
					if(type.equals("Date")){
						if(properties.getProperty(param+"."+type) != null){
							fields[i].set(ob, sdf.parse(properties.getProperty(param+"."+type)));
						}
					}
					if (type.equals("List") && properties.getProperty(param+"."+type) != null) {
						String[] str = properties.getProperty(param+"."+type).split(ZAP);
						for (int k = 0; k < str.length; k++) {
							listType.add(str[k]);
						}
						fields[i].set(ob, listType);
					}
				}

				fields[i].setAccessible(false);
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
}
