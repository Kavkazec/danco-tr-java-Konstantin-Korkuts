package com.danco.training.seriolize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(PropertiesReader.getInstance().getUtil().getPath());
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Hotel.getInstance());
			oos.flush();
			fos.close();
			oos.close();
		}  catch (IOException e) {
			LOGGER.error("IOEXCEPRION",e);
		}
	}
	
	public void readFromFile() {
		PropertiesReader.getInstance().setProperties();
		try {
			FileInputStream fis = new FileInputStream(PropertiesReader.getInstance().getUtil().getPath());
			ObjectInputStream oin = new ObjectInputStream(fis);
			Hotel hotel = (Hotel) oin.readObject();
			Hotel.getInstance().setGuest(hotel.getGuest());
			Hotel.getInstance().setRoom(hotel.getRoom());
			Hotel.getInstance().setService(hotel.getService());
			fis.close();
			oin.close();
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error("IOEXCEPRION_OR_CLASSNOTFOUND",e);
		}

	}
}
