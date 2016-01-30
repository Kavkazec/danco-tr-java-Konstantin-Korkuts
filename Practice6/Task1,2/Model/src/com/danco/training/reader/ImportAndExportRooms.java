package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.model.RoomModel;
import com.danco.training.model.ServiceModel;
import com.danco.training.service.HotelService;

public class ImportAndExportRooms {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportRooms.class);
	private HotelService service;
	public HotelService getService() {
		if(service == null){
			service = HotelService.getInstance();
		}
		return service;
	}
	
	public void writeToFileRooms(String path){
		try {
			FileWriter fw = new FileWriter(path);
			fw.append(RoomModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().getRooms().size(); i++){
				fw.append(getService().getRooms().get(i).getNumber() + "");
				fw.append(SEPAR);
				fw.append(getService().getRooms().get(i).getCapacity() + "");
				fw.append(SEPAR);
				fw.append(getService().getRooms().get(i).getNumberOfStars() + "");
				fw.append(SEPAR);
				fw.append(getService().getRooms().get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(getService().getRooms().get(i).getStatus() + "");
				fw.append(SEPAR);
				fw.append(getService().getRooms().get(i).getIsOnRepair() + "");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		}catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} 
	}
	
	public void readFromFileRooms(String path){
		List<String> list = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(RoomModel.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					int number = Integer.parseInt(arr[0]);
					int capacity = Integer.parseInt(arr[1]);
					int stars = Integer.parseInt(arr[2]);
					int coast = Integer.parseInt(arr[3]);
					boolean status = Boolean.parseBoolean(arr[4]);
					boolean onRepair = Boolean.parseBoolean(arr[6]);
					RoomModel rm = new RoomModel(number, capacity, stars, coast);
					rm.setStatus(status);
					rm.setOnRepair(onRepair);
					getService().addRoom(rm);
				}
			}
			bf.close();
		}catch (FileNotFoundException e) {
			LOGGER.error("FILE_NOT_FOUND_EXCPTION",e);
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		}
	
	}
	
}
