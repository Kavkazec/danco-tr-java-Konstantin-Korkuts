package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.model.ServiceModel;
import com.danco.training.service.HotelService;

public class ImportAndExportServices {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportServices.class);
	private HotelService service;
	public HotelService getService() {
		if(service == null){
			service = HotelService.getInstance();
		}
		return service;
	}
	
	public void writeToFileServices(String path){
		try {
			FileWriter fw = new FileWriter(path);
			fw.append(ServiceModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().getServices().size(); i++){
				fw.append(getService().getServices().get(i).getName());
				fw.append(SEPAR);
				fw.append(getService().getServices().get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		}catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} 
	}
	
	public void readFromFileServices(String path){
		List<String> list = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(ServiceModel.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					int coast = Integer.parseInt(arr[1]);
					getService().addService(new ServiceModel(name, coast));
				}
			}
			bf.close();
		}  catch (FileNotFoundException e) {
			LOGGER.error("FILE_NOT_FOUND_EXCPTION",e);
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		}
	}
}
