package com.danco.training.server;

public class ServerInit {
	public static void main(String[] args){
		Server s = new Server(3000);
		s.start();
	}
}
