package com.danco.training.main;

import com.danco.training.controller.HotelController;
import com.danco.training.controller.api.IHotelController;
import com.danco.training.di.DependencyInjection;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args){
		IHotelController hotel  = (IHotelController) DependencyInjection.getInstance().getClassInstance(IHotelController.class);
		hotel.addService();
		hotel.printService();
		
	}
}
