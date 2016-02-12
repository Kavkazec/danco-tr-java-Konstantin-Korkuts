package com.danco.training.client;

import java.io.IOException;
import java.io.ObjectInputStream;
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
		ObjectInputStream ois = null;
		Socket socket = null;
		try {
			socket = new Socket(servIP, servPort);
			oos =  new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			MainController con = new MainController();
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		}finally {
			try {
				oos.close();
				ois.close();
				socket.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
			
		}
	}
}
