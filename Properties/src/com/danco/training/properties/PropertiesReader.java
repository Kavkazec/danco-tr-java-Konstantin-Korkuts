package com.danco.training.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesReader {
	private static Logger logger = Logger.getLogger(PropertiesReader.class);
	private PropertiesUtil util = new PropertiesUtil();
	private static final String ZAP = ",";
	
	
	
	private static PropertiesReader instance;
	
	private PropertiesReader(){
		
	}
	
	public static PropertiesReader getInstance(){
		if(instance == null){
			instance = new PropertiesReader();
		}
		return instance;
	}
	
	private static final String RECORD_KEY = "RECORD";
	private static final String SWITCH_KEY = "SWITCH_OFF";
	private static final String PATH = "Path";
	private static final String CSVPATH = "CSV";
	private static final String PATH_ANNOT = "PathAnnotation";
	private static final String SERVICE_NAME = "ServiceName";

	
	public void setProperties(){
		FileInputStream reader = null;
		try {
			reader = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(reader);
			Boolean swith = Boolean.parseBoolean(properties.getProperty(SWITCH_KEY));
			int record = Integer.parseInt(properties.getProperty(RECORD_KEY));
			String path = properties.getProperty(PATH);
			String csvPath = properties.getProperty(CSVPATH);
			String annotPath = properties.getProperty(PATH_ANNOT);
			String servName = properties.getProperty(SERVICE_NAME);
			util.setSwitchOff(swith);
			util.setRecordNumber(record);
			util.setPath(path);
			util.setCsvPath(csvPath);
			util.setAnnotPath(annotPath);
			util.setServName(servName);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} finally{
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
	}
	
	public PropertiesUtil getUtil() {
		return util;
	}
	
	
}
