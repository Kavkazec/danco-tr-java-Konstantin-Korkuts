package com.danco.training.client;

import java.util.Scanner;

public class ClientInit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter server ip:");
		String ip = scanner.nextLine();
		System.out.println("Please enter server port:");
		int port = scanner.nextInt();
		Client c = new Client(ip, port);
		c.start();
		scanner.close();
	}
}
