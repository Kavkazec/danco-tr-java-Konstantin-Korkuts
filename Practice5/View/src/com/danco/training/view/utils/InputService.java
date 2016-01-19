package com.danco.training.view.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.danco.training.model.ServiceModel;

public class InputService {
	public static ServiceModel inputService() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Name:");
			String name;
			name = bf.readLine();
			System.out.println("Coast:");
			int coast = Integer.parseInt(bf.readLine());
			return new ServiceModel(name, coast);
	}
}
