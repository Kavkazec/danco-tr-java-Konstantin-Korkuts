package com.danco.training.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.training.controller.api.IHotelController;

public class ThreatsForClinets extends Thread{
	private Logger logger = Logger.getLogger(ThreatsForClinets.class);
	private Socket fromClient;
	private IHotelController hotelController;
	private DataProcessing processor;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public ThreatsForClinets(Socket fromClient, IHotelController hotelController) {
		this.fromClient = fromClient;
		this.hotelController = hotelController;
		this.processor = new DataProcessing(hotelController);
	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(fromClient.getOutputStream());
			ois = new ObjectInputStream(fromClient.getInputStream());
			Object input;
			Object output;
			while ((input = ois.readObject()) != null) {
				output = processor.executeCommand(input);
				if (output == "Exit") {
					break;
				}
				if (output == "EMPTY") {
					oos.reset();
					oos.writeObject(null);
					oos.flush();
				}
				if (output != null) {
					oos.reset();
					oos.writeObject(output);
					oos.flush();
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				oos.close();
				ois.close();
				fromClient.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
}
