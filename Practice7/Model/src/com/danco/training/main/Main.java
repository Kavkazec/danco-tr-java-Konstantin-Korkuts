package com.danco.training.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.danco.training.model.ServiceModel;
import com.danco.training.processing.ProcessingAnnotation;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.service.HotelService;
import com.danco.training.storage.Hotel;

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
	public static void main(String[] args) throws ParseException{
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Hotel hotel = Hotel.getInstance();
		
		ServiceModel s1 = new ServiceModel("gg", 100);
		hotel.addService(s1);
		
		HotelService hs = HotelService.getInstance();
		ProcessingAnnotation pro = new ProcessingAnnotation();
		
		
		for(int i = 0; i < hotel.getService().getListOfServices().size(); i++){
			System.out.println(hotel.getService().getListOfServices().get(i).getName() 
					+"\n"+ hotel.getService().getListOfServices().get(i).getCoast());
		}
		System.out.println(s1.getClass().getName());
		pro.procAnnotation(s1.getClass().getName());
		s1.setName(pro.getStrType());
		s1.setCoast(pro.getIntType());
		System.out.println(s1.getName() + s1.getCoast());
	}

}
