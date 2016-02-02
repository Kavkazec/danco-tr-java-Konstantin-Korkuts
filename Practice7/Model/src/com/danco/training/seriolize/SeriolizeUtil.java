package com.danco.training.seriolize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.danco.training.service.HotelService;
import com.danco.training.storage.Hotel;

public class SeriolizeUtil {
	private static final Logger LOGGER = Logger.getLogger(SeriolizeUtil.class);

	public void writeInFile(String path){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(HotelService.getInstance().getHotel());
			oos.flush();
			oos.close();
		}  catch (IOException e) {
			LOGGER.error("IOEXCEPRION",e);
		}
	}
	
	public void readFromFile(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream oin = new ObjectInputStream(fis);
			Hotel hotel = (Hotel) oin.readObject();
			Hotel.getInstance().setGuest(hotel.getGuest());
			Hotel.getInstance().setRoom(hotel.getRoom());
			Hotel.getInstance().setService(hotel.getService());
			oin.close();
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error("IOEXCEPRION_OR_CLASSNOTFOUND",e);
		}

	}
}
