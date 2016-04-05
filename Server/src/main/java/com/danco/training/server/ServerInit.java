package com.danco.training.server;

import java.util.Scanner;

public class ServerInit {
	public static void main(String[] args){
		System.out.println("Please, input server port number:");
		Scanner scanner = new Scanner(System.in);
		int port = scanner.nextInt();
		Server server = new Server(port);
		server.start();
		scanner.close();
	}
}
