package com.danco.training.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.danco.training.entity.Act;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.User;
import com.danco.training.service.ActService;
import com.danco.training.service.GuestService;
import com.danco.training.service.RoomService;
import com.danco.training.service.ServiceService;
import com.danco.training.service.UserService;

public class Test {
	
	public static void main(String[] args) {
		RoomService ser = new RoomService();
		Room room = ser.getByIdRoom(5);
		System.out.println(room.getNumber());
	}
}
