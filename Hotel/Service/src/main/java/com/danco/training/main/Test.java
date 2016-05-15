package com.danco.training.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.danco.training.entity.Act;
import com.danco.training.entity.User;
import com.danco.training.service.ActService;
import com.danco.training.service.UserService;

public class Test {
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		Date date = new Date();
		System.out.println(sdf.format(date));
	}
}
