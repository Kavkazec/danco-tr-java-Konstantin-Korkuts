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

public class ImportAndExport {
    private ImportAndExportGuests guest;
    private ImportAndExportRooms room;
    private ImportAndExportServices service;
    
    public ImportAndExportGuests getGuest() {
    	if(guest == null){
    		guest = new ImportAndExportGuests();
    	}
		return guest;
	}



	public ImportAndExportRooms getRoom() {
		if(room == null){
			room = new ImportAndExportRooms();
    	}
		return room;
	}



	public ImportAndExportServices getService() {
		if(service == null){
			service = new ImportAndExportServices();
    	}
		return service;
	}

	private static ImportAndExport instance;
    
    public static ImportAndExport getInstance(){
    	if(instance == null){
    		instance = new ImportAndExport();
    	}
    	return instance;
    }
    
    private ImportAndExport(){
    	
    }
    public void writeToFileGuests(String path){
    	getGuest().writeToFileGuests(path);
    }
    
    public void writeToFileRooms(String path){
    	getRoom().writeToFileRooms(path);
    }
    
    public void writeToFileServices(String path){
    	getService().writeToFileServices(path);
    }
    
    public void readFromFileServices(String path){
    	getService().readFromFileServices(path);
    }
    public void readFromFileRooms(String path){
    	getRoom().readFromFileRooms(path);
    }
    public void readFromFileGuests(String path){
    	getGuest().readFromFileGuests(path);
    }
}
