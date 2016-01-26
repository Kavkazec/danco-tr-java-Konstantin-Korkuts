package com.danco.training.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */
public class Config {
	
	/** The log properties. */
	private static Properties logProperties = new Properties();
	
	/** The log file. */
	private String logFile;
	
	/**
	 * Instantiates a new config.
	 *
	 * @param logFile the log file
	 */
	public Config(String logFile){
		this.logFile = logFile;
	}
	
	/**
	 * Inits the.
	 */
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
