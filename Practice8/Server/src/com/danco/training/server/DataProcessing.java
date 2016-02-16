package com.danco.training.server;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.danco.training.controller.api.IHotelController;

public class DataProcessing {
	private final Logger logger = Logger.getLogger(DataProcessing.class);
	private IHotelController hotelController;

	public DataProcessing(IHotelController hotelController) {
		this.hotelController = hotelController;
	}

	public Object executeCommand(Object command) {
		Object answer = "EMPTY";
		Class<?> bsClass = hotelController.getClass();
		for (Method method : bsClass.getMethods()) {
			if (command instanceof Transmission) {
				if (method.getName().equals(((Transmission) command).getNameOfMethod())) {
					try {
						if (((Transmission) command).getNameOfMethod() != "Exit") {
							if (((Transmission) command).getArgs().length != 0) {
								if (method.getReturnType() != void.class) {
									answer = method.invoke(hotelController, ((Transmission) command).getArgs());
								} else {
									method.invoke(hotelController, ((Transmission) command).getArgs());
								}
							} else {
								if (method.getReturnType() != void.class) {
									answer = method.invoke(hotelController);
								} else {
									method.invoke(hotelController);
								}
							}
						} else {
							answer = "Exit";
						}
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return answer;
	}
}
