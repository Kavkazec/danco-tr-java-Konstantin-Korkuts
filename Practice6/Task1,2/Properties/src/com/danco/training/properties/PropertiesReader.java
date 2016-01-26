package com.danco.training.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesReader {
	private static Logger logger = Logger.getLogger(PropertiesReader.class);

	private PropertiesUtil util = new PropertiesUtil();
	
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

	
	public void setProperties(){
		try {
			FileInputStream reader = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(reader);
			Boolean swith = Boolean.parseBoolean(properties.getProperty(SWITCH_KEY));
			int record = Integer.parseInt(properties.getProperty(RECORD_KEY));
			String path = properties.getProperty(PATH);
			String csvPath = properties.getProperty(CSVPATH);
			util.setSwitchOff(swith);
			util.setRecordNumber(record);
			util.setPath(path);
			util.setCsvPath(csvPath);
		} catch (FileNotFoundException e) {
			logger.error("FILE_NOT_FOUND");
		} catch (IOException e) {
			logger.error("IOEXCEPTION");
		}
	}
	
	public PropertiesUtil getUtil() {
		return util;
	}
}
