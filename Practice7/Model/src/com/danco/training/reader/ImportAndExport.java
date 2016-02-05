package com.danco.training.reader;

import java.util.List;


import com.danco.training.entity.GuestModel;
import com.danco.training.entity.RoomModel;
import com.danco.training.entity.ServiceModel;

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
    
    public List<ServiceModel> readFromFileServices(String path){
    	return getService().readFromFileServices(path);
    }
    public List<RoomModel> readFromFileRooms(String path){
    	return getRoom().readFromFileRooms(path);
    }
    public List<GuestModel> readFromFileGuests(String path){
    	return getGuest().readFromFileGuests(path);
    }
}
