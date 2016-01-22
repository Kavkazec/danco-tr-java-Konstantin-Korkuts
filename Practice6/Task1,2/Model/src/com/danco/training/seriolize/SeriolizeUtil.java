package com.danco.training.seriolize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.danco.training.storage.Hotel;

public class SeriolizeUtil {
	private static final Logger LOGGER = Logger.getLogger(SeriolizeUtil.class);
	private static final String PATH = "Path";
	private String path;
	
	private static SeriolizeUtil instance;
	
	private SeriolizeUtil(){
		
	}
	
	public static SeriolizeUtil getInstatcne(){
		if(instance == null){
			instance = new SeriolizeUtil();
		}
		return instance;
	}
	
	
	public String getPath() {
		return path;
	}

	public void setPath() {
		FileInputStream reader;
		try {
			reader = new FileInputStream("config.seriolize");
			Properties properties = new Properties();
			properties.load(reader);
			path = properties.getProperty(PATH);
		} catch (IOException e) {
			LOGGER.error("IOEXCEPRION",e);
		}
	}
	
	public void writeInFile(){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(getPath());
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Hotel.getInstance());
			oos.flush();
			oos.close();
		}  catch (IOException e) {
			LOGGER.error("IOEXCEPRION",e);
		}
	}
	
	public void ReadFromFile() {
		try {
			FileInputStream fis = new FileInputStream(getPath());
			ObjectInputStream oin = new ObjectInputStream(fis);
			Hotel hotel  = (Hotel) oin.readObject();
			oin.close();
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error("IOEXCEPRION_OR_CLASSNOTFOUND",e);
		}

	}
}
