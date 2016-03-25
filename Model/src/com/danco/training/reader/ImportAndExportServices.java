package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Service;
import com.danco.training.service.ServiceService;

public class ImportAndExportServices {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportServices.class);
	private ServiceService service;
	public ServiceService getService() {
		if(service == null){
			service = new ServiceService();
		}
		return service;
	}
	
	public void writeToFileServices(String path){
		FileWriter fw = null;
		List<Service> list = getService().getServices();
		try {
			fw = new FileWriter(path);
			fw.append(Service.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < list.size(); i++){
				fw.append(list.get(i).getName());
				fw.append(SEPAR);
				fw.append(list.get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
		}catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);;
			}
		}
	}
	
	public List<Service> readFromFileServices(String path){
		List<String> list = new ArrayList<String>();
		List<Service> services = new ArrayList<Service>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(Service.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					int coast = Integer.parseInt(arr[1]);
					Service sm = new Service(name, coast);
					if(!equalID(name, services)){
						services.add(sm);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally{
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		return services;
	}
	
	public boolean equalID(String name, List<Service> list){
		boolean b = false;
		for(Service model: list){
			if(model.getName().equals(name)){
				b = true;
				break;
			}
		}
		return b;
	}
}
