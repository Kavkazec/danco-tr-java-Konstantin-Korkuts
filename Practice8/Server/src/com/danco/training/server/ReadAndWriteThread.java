package com.danco.training.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.training.controller.api.IHotelController;

public class ReadAndWriteThread extends Thread{
	private static final Logger LOGGER = Logger.getLogger(ReadAndWriteThread.class);
	private Socket fromClient;
	private IHotelController hotelController;

	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public ReadAndWriteThread(Socket fromClient, IHotelController hotelController) {
		this.fromClient = fromClient;
		this.setHotelController(hotelController);

	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(fromClient.getOutputStream());
			ois = new ObjectInputStream(fromClient.getInputStream());
			Object input;
			Object output;
			while ((input = ois.readObject()) != null) {

			}

		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (ClassNotFoundException e) {	
			LOGGER.error(e.getMessage(),e);
		} finally {
			try {
				oos.close();
				ois.close();
				fromClient.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}

	public void setHotelController(IHotelController hotelController) {
		this.hotelController = hotelController;
	}

}
