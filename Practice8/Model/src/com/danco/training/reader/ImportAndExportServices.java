package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.ServiceModel;
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
		try {
			FileWriter fw = new FileWriter(path);
			fw.append(ServiceModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().printService().size(); i++){
				fw.append(getService().printService().get(i).getName());
				fw.append(SEPAR);
				fw.append(getService().printService().get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		}catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} 
	}
	
	public List<ServiceModel> readFromFileServices(String path){
		List<String> list = new ArrayList<String>();
		List<ServiceModel> services = new ArrayList<ServiceModel>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(ServiceModel.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					int coast = Integer.parseInt(arr[1]);
					ServiceModel sm = new ServiceModel(name, coast);
					if(!equalID(name, services)){
						services.add(sm);
					}
				}
			}
			
		}  catch (FileNotFoundException e) {
			LOGGER.error("FILE_NOT_FOUND_EXCPTION",e);
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} finally{
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error("IOEXCEPTION",e);
			}
		}
		return services;
	}
	
	public boolean equalID(String name, List<ServiceModel> list){
		boolean b = false;
		for(ServiceModel model: list){
			if(model.getName().equals(name)){
				b = true;
				break;
			}
		}
		return b;
	}
}
