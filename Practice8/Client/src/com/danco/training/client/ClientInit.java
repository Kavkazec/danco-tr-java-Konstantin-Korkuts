package com.danco.training.client;

public class ClientInit {
	public static void main(String[] args) {
			Client c = new Client("localhost", 3000);
			c.start();
	}
}
