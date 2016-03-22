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

import com.danco.training.entity.GuestModel;
import com.danco.training.service.GuestService;

public class ImportAndExportGuests {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
		try {
			fw = new FileWriter(path);
			fw.append(GuestModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().printGuest().size(); i++){
				fw.append(getService().printGuest().get(i).getName());
				fw.append(SEPAR);
				fw.append(sdf.format(getService().printGuest().get(i).getDateOfAdd()));
				fw.append(SEPAR);
				fw.append(sdf.format(getService().printGuest().get(i).getDateOfEvi()));
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
	
	public List<GuestModel> readFromFileGuests(String path){
		List<String> list = new ArrayList<String>();
		List<GuestModel> guests = new ArrayList<GuestModel>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(GuestModel.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					Date add = sdf.parse(arr[1]);
					Date evi = sdf.parse(arr[2]);
					GuestModel gm = new GuestModel(name, add, evi);
					if(!equalID(name, add, guests)){
						guests.add(gm);
					}
				}
			}
		}catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (ParseException e) {
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
	
	public boolean equalID(String name, Date date, List<GuestModel> list){
		GuestModel gm = null;
		for(GuestModel model: list){
			if(model.getName().equals(name) && model.getDateOfAdd().equals(date)){
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
