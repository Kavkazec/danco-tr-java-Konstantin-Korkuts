package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.RoomModel;
import com.danco.training.service.RoomService;

public class ImportAndExportRooms {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportRooms.class);
	private RoomService service;
	public RoomService getService() {
		if(service == null){
			service = new RoomService();
		}
		return service;
	}
	
	public void writeToFileRooms(String path){
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			fw.append(RoomModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().printRoom().size(); i++){
				fw.append(getService().printRoom().get(i).getNumber() + "");
				fw.append(SEPAR);
				fw.append(getService().printRoom().get(i).getCapacity() + "");
				fw.append(SEPAR);
				fw.append(getService().printRoom().get(i).getNumberOfStars() + "");
				fw.append(SEPAR);
				fw.append(getService().printRoom().get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(getService().printRoom().get(i).getStatus() + "");
				fw.append(SEPAR);
				fw.append(getService().printRoom().get(i).getIsOnRepair() + "");
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
				LOGGER.error(e.getMessage(),e);
			}
		}
	}
	
	public List<RoomModel> readFromFileRooms(String path){
		List<String> list = new ArrayList<String>();
		List<RoomModel> rooms = new ArrayList<RoomModel>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
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
					if(!equalID(number, rooms)){
						rooms.add(rm);
					}
				}
			}
		}catch (FileNotFoundException e) {
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
		return rooms;
	
	}
	
	public boolean equalID(int number, List<RoomModel> list){
		RoomModel rm = null;
		for(RoomModel model: list){
			if(model.getNumber() == number){
				rm = model;
				break;
			}
		}
		if(rm == null){
			return true;
		}
		return false;
		
	}
	
}
