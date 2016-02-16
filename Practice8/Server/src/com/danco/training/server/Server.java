package com.danco.training.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.training.controller.api.IHotelController;
import com.danco.training.di.DependencyInjection;
import com.danco.training.properties.PropertiesReader;

public class Server {
	private int port;
	private IHotelController hotelController = (IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class);
	private Logger logger = Logger.getLogger(Server.class);
	public Server(int port) {
		PropertiesReader.getInstance().setProperties();
		this.port = port;
	}

	public void start() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				new ThreatsForClinets(clientSocket, hotelController).start();
			}
		} catch (IOException e) {
			System.out.println("Can't accept");
			System.exit(-1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

	}
}
