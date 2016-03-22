package com.danco.training.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.training.view.menu.MainController;

public class Client {

	private String serverIP;
	private int serverPort;
	private MainController menuController;
	private Logger logger = Logger.getLogger(Client.class);

	public Client(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}

	public void start() {
		try (Socket fromServer = new Socket(serverIP, serverPort);
			ObjectOutputStream out = new ObjectOutputStream(fromServer.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(fromServer.getInputStream())){
					menuController = new MainController();
					while(menuController.getExitFlag() != true) {
						menuController.run(out, in);
					}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
