package com.danco.training.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesReader {
	private static Logger logger = Logger.getLogger(PropertiesUtil.class);

	private PropertiesUtil util = new PropertiesUtil();
	
	private static final String RECORD_KEY = "RECORD";
	private static final String SWITCH_KEY = "SWITCH_OFF";

	
	public void setProperties(){
		try {
			FileInputStream reader = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(reader);
			Boolean swith = Boolean.parseBoolean(properties.getProperty(SWITCH_KEY));
			int record = Integer.parseInt(properties.getProperty(RECORD_KEY));
			util.setSwitchOff(swith);
			util.setRecordNumber(record);
		} catch (FileNotFoundException e) {
			logger.error("FILE_NOT_FOUND",e);
		} catch (IOException e) {
			logger.error("IOEXCEPTION",e);
		}
	}
	
	public PropertiesUtil getUtil() {
		return util;
	}
}
