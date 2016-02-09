package com.danco.training.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.danco.training.view.menu.MainController;

public class Client {
	private String servIP;
	private int servPort;
	private static final Logger LOGGER = Logger.getLogger(Client.class);
	public Client(String servIP, int servPort){
		this.servIP = servIP;
		this.servPort = servPort;
	}
	
	public void start(){
		BasicConfigurator.configure();
		ObjectOutputStream oos = null;
		try {
			MainController m = new MainController();
			m.run();
			Socket socket = new Socket(servIP, servPort);
			oos =  new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			LOGGER.error("UnknownHostException",e);
		} catch (IOException e) {
			LOGGER.error("IOExeption",e);
		}
	}
}
