package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Guest;
import com.danco.training.service.GuestService;

public class ImportAndExportGuests {
	
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportGuests.class);
	private GuestService service;
	public GuestService getService() {
		if(service == null){
			service = new GuestService();
		}
		return service;
	}
	
	public void writeToFileGuests(String path){
		FileWriter fw = null;
		List<Guest> list = getService().getGuests();
		try {
			fw = new FileWriter(path);
			fw.append(Guest.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < list.size(); i++){
				fw.append(list.get(i).getName());
				fw.append(SEPAR);
				fw.append(list.get(i).getPassportSeries());
				fw.append(SEPAR);
				fw.append(list.get(i).getPassportNumber()+"");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}
	
	public List<Guest> readFromFileGuests(String path){
		List<String> list = new ArrayList<String>();
		List<Guest> guests = new ArrayList<Guest>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(Guest.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					String passSer = arr[1];
					int passNum = Integer.parseInt(arr[2]);
					Guest gm = new Guest(name, passSer, passNum);
					if(!equalID(name, passNum, guests)){
						guests.add(gm);
					}
				}
			}
		}catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		return guests;
	
	}
	
	public boolean equalID(String name, int number, List<Guest> list){
		Guest gm = null;
		for(Guest model: list){
			if(model.getName().equals(name) && model.getPassportNumber()==number){
				gm = model;
				break;
			}
		}
		if(gm == null){
			return true;
		}
		return false;
		
	}
	
}
