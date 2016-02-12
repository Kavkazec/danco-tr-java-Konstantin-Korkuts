package com.danco.training.server;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

import com.danco.training.controller.api.IHotelController;
import com.danco.training.di.DependencyInjection;

public class Server {
	private int port;
	private IHotelController hotel  = (IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class);
	private static final Logger LOGGER = Logger.getLogger(Server.class);
	public Server(int port){
		this.port = port;
	}
	
	public void start(){
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}
}
