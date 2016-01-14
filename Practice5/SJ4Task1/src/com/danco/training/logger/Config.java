package com.danco.training.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Config {
	private static Properties logProperties = new Properties();
	private static String logFile;
	
	public Config(String logFile){
		this.logFile = logFile;
	}
	
	public void init(){
		try {
			logProperties.load(new FileInputStream(logFile));
			PropertyConfigurator.configure(logProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
