package com.danco.training.di;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.danco.training.properties.PropertiesReader;

public class DIConfig {
	
	private final static Logger LOGGER = Logger.getLogger(DIConfig.class.getName());

	private static DIConfig instance;

	private Properties properties;
	
	private PropertiesReader propReader = PropertiesReader.getInstance();
	
	private FileInputStream fileInputStream;

	public static DIConfig getInstance() {
		if (instance == null) {
			instance = new DIConfig();
		}
		return instance;
	}

	private DIConfig() {
		properties = new Properties();
		propReader.setProperties();
		File file = new File(propReader.getUtil().getServName());
		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			if (fileInputStream != null) {
			}
			try {
				fileInputStream.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}

	public String getImplClassName(String iName) {
		return properties.getProperty(iName);

	}
}
