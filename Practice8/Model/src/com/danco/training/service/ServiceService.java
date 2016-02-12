package com.danco.training.service;


import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.annotation.ProcessAnnotation;
import com.danco.training.controller.api.IServiceService;
import com.danco.training.entity.ServiceModel;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.properties.init.annotation.InitServerAnnotation;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.storage.Hotel;

	// TODO: Auto-generated Javadoc
/**
	 * The Class ServiceService.
	 */
	public class ServiceService implements IServiceService{
	private static final Logger logger = Logger.getLogger(GuestService.class);
	/** The hotel. */
	private Hotel hotel = Hotel.getInstance();
	
	/**
	 * Instantiates a new service service.
	 */
	
	/**
	 * Adds the service.
	 *
	 * @param service the service
	 */
	public void addService(ServiceModel service){
		try{
			hotel.addService(service);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Delete service.
	 *
	 * @param service the service
	 */
	public void deleteService(String name){
		try{
			hotel.deleteService(name);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<ServiceModel> printService(){
		try{
			return hotel.getService().getListOfServices();
		}catch (Exception e) {
			logger.error("EXPTION", e);
			return null;
		}
	}
	
	/**
	 * Change status.
	 *
	 * @param name the name
	 * @param coast the coast
	 */
	public void changeServicesCoast(String name,int coast){	
		try{
			for(ServiceModel m: hotel.getService().getListOfServices()){
				if(m.getName() == name){
					m.setCoast(coast);
				}
			}	
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void exportServices(){
		try{
			PropertiesReader.getInstance().setProperties();
			ImportAndExport.getInstance().writeToFileServices(PropertiesReader.getInstance().getUtil().getCsvPath());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void importServices(){
		try{
			PropertiesReader.getInstance().setProperties();
			hotel.getService().setServices(ImportAndExport.getInstance().readFromFileServices(PropertiesReader.getInstance().getUtil().getCsvPath()));
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void buildServicesFromAnnot(){
		PropertiesReader.getInstance().setProperties();
		ProcessAnnotation p = new ProcessAnnotation();
		InitServerAnnotation s = new InitServerAnnotation();
		p.procAnnotation(s);
		hotel.getService().setServices(s.buildServices());
	}
}
