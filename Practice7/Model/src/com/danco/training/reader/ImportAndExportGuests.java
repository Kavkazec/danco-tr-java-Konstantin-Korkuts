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

import com.danco.training.model.GuestModel;
import com.danco.training.model.RoomModel;
import com.danco.training.service.HotelService;

public class ImportAndExportGuests {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportGuests.class);
	private HotelService service;
	public HotelService getService() {
		if(service == null){
			service = HotelService.getInstance();
		}
		return service;
	}
	
	public void writeToFileGuests(String path){
		try {
			FileWriter fw = new FileWriter(path);
			fw.append(GuestModel.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < getService().getGuests().size(); i++){
				fw.append(getService().getGuests().get(i).getName());
				fw.append(SEPAR);
				fw.append(sdf.format(getService().getGuests().get(i).getDateOfAdd()));
				fw.append(SEPAR);
				fw.append(sdf.format(getService().getGuests().get(i).getDateOfEvi()));
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} 
	}
	
	public void readFromFileGuests(String path){
		List<String> list = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(GuestModel.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					String name = arr[0];
					Date add = sdf.parse(arr[1]);
					Date evi = sdf.parse(arr[2]);
					getService().addGuest(new GuestModel(name, add, evi));
				}
			}
			bf.close();
		}catch (FileNotFoundException e) {
			LOGGER.error("FILE_NOT_FOUND_EXCPTION",e);
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION",e);
		} catch (ParseException e) {
			LOGGER.error("PARSE_EXCEPTION",e);
		}
	
	}
	
}
