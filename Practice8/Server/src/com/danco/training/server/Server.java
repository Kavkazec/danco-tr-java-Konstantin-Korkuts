package com.danco.training.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Server {
	private int port;
	private static final Logger LOGGER = Logger.getLogger(Server.class);
	public Server(int port){
		this.port = port;
	}
	
	public void start(){
		ServerSocket server = null;
		InputStream in = null;
		OutputStream out = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			BasicConfigurator.configure();
			server = new ServerSocket(port);
			Socket socket = server.accept();
			in = socket.getInputStream();
			out = socket.getOutputStream();
			oos = new ObjectOutputStream(out);
			ois = new ObjectInputStream(in);
		} catch (IOException e) {
			LOGGER.error("IOExeption",e);
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				LOGGER.error("IOExeption",e);
			}
		}
	}
}
