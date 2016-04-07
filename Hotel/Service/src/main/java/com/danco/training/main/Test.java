package com.danco.training.main;


import com.danco.training.api.IRoomDao;
import com.danco.training.di.DependencyInjection;
import com.danco.training.persisexception.PersistenceException;
import com.danco.training.service.RoomService;

public class Test {
	public static void main(String[] args) throws PersistenceException{
		RoomService rs = new RoomService();
		System.out.println(rs.getRooms().size());
	}
}
