package com.danco.training.processing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.properties.PropertiesReader;

public class ProcessingAnnotation {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private String path;
	private String param;
	private String type;
	private int intType;
	private String strType;
	private Date dateType;
	private List<String> listType;
	
	public List<String> getListType() {
		return listType;
	}

	public void setListType(String str) {
		this.listType.add(str);
	}

	public int getIntType() {
		return intType;
	}

	public void setIntType(int intType) {
		this.intType = intType;
	}

	public String getStrType() {
		return strType;
	}

	public void setStrType(String strType) {
		this.strType = strType;
	}

	public Date getDateType() {
		return dateType;
	}

	public void setDateType(Date dateType) {
		this.dateType = dateType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParam() {
		return param;
	}

	public String getType() {
		return type;
	}
	
	public ProcessingAnnotation(){
		
	}

	public void procAnnotation(String className){
		PropertiesReader.getInstance().setProperties();
		try {
			Class<?> cl = Class.forName(className);
			Field[] fields = cl.getDeclaredFields();
			for(int i = 0; i < fields.length; i++){
				if(fields[i].isAnnotationPresent(ConfigPropery.class)){
					ConfigPropery ann = fields[i].getAnnotation(ConfigPropery.class);
					setPath(ann.cPath());
					setParam(ann.param());
					setType(ann.type());
					FileInputStream reader = new FileInputStream(getPath());
					Properties properties = new Properties();
					properties.load(reader);
					if(getType().equals("int")){
						setIntType(Integer.parseInt(properties.getProperty(getParam()
								+"."+getType())));
					}
					if(getType().equals("String")){
						setStrType(properties.getProperty(getParam()+"."+getType()));
					}
					
					if(getType().equals("Date")){
						if(properties.getProperty(getParam()+"."+getType()) != null){
							setDateType(sdf.parse(properties.getProperty(getParam()
									+"."+getType())));
						}
					}
					if(getType().equals("list")){
						setListType(properties.getProperty(getParam()+"."+getType()));
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
