package com.danco.training.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.training.di.DependencyInjection;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.services.api.IHotelController;

public class Server {
	private int port;
	private IHotelController hotelController;
	private final Logger LOGGER = Logger.getLogger(Server.class);
	public Server(int port) {
		this.port = port;
		PropertiesReader.getInstance().setProperties();
	}
	
	public IHotelController getHotelController(){
		if(hotelController == null){
			hotelController = (IHotelController)DependencyInjection.getInstance().getClassInstance(IHotelController.class);
		}
		return hotelController;
	}

	public void start(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				Socket clientSocket = serverSocket.accept();
				new ThreatsForClinets(clientSocket, getHotelController()).start();
			}
		} catch (IOException e) {
			System.out.println("Can't accept");
			System.exit(-1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

	}
}
