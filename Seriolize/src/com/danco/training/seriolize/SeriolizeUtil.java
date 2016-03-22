package com.danco.training.seriolize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.danco.training.properties.PropertiesReader;
import com.danco.training.storage.Hotel;

public class SeriolizeUtil {
	private static final Logger LOGGER = Logger.getLogger(SeriolizeUtil.class);
	private static SeriolizeUtil instance;
	
	public static SeriolizeUtil getInstance(){
		if(instance == null){
			instance = new SeriolizeUtil();
		}
		return instance;
	}
	
	public void writeInFile(){
		PropertiesReader.getInstance().setProperties();
		BasicConfigurator.configure();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(PropertiesReader.getInstance().getUtil().getPath());
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Hotel.getInstance());
			oos.flush();
		}  catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		}finally{
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
			
		}
	}
	
	public void readFromFile() {
		PropertiesReader.getInstance().setProperties();
		BasicConfigurator.configure();
		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream(PropertiesReader.getInstance().getUtil().getPath());
			oin = new ObjectInputStream(fis);
			Hotel hotel = (Hotel) oin.readObject();
			Hotel.getInstance().setGuest(hotel.getGuest());
			Hotel.getInstance().setRoom(hotel.getRoom());
			Hotel.getInstance().setService(hotel.getService());
			
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error(e.getMessage(),e);
		}finally{
			try {
				fis.close();
				oin.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
			
		}

	}
}
