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
import com.danco.training.model.ServiceModel;

public class Export {
	private static final String PARSE = " ; ";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static final Logger LOGGER = Logger.getLogger(Export.class);
    
    private static Export instance;
    
    public static Export getInstance(){
    	if(instance == null){
    		instance = new Export();
    	}
    	return instance;
    }
    
	public <E> void writeToFile(String path, List<E> list) {
		try {
			FileWriter fw = new FileWriter(path);
			List<E> rm = list;
			for (int i = 0; i < rm.size(); i++) {
				fw.append(rm.get(i).toString());
				fw.append('\n');
				fw.flush();
			}
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION");
		}
	}

	public <E> List<E> readFromFile(String path) {
		String line = "";
		List<E> list = new ArrayList<E>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			while ((line = bf.readLine()) != null) {
				String[] arr = line.split(PARSE);
				if (arr.length == 5) {
					int num = Integer.parseInt(arr[0]);
					int cap = Integer.parseInt(arr[1]);
					int sta = Integer.parseInt(arr[2]);
					int coa = Integer.parseInt(arr[3]);
					boolean b = Boolean.parseBoolean(arr[4]);
					RoomModel rm = new RoomModel(num, cap, sta, coa);
					rm.setStatus(b);
					list.add((E) rm);
				}
				if (arr.length == 2) {
					String nam = arr[0];
					int coa = Integer.parseInt(arr[1]);
					list.add((E) new ServiceModel(nam,coa));
				}
				if(arr.length == 3) {
					String nam = arr[0];
					Date dAr = sdf.parse(arr[1]);
					Date dEv = sdf.parse(arr[2]);
					list.add((E) new GuestModel(nam, dAr, dEv));
				}
				
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("FILE_NOT_FOUND_EXCPTION");
		} catch (IOException e) {
			LOGGER.error("IOEXCEPTION");
		} catch (ParseException e) {
			LOGGER.error("PARSE_EXCEPTION");
		}
		return list;
	}
}
