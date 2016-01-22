package com.danco.training.controller.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.danco.training.logger.Config;

public class InReader {
	private static final String LOGFILE = "log4j.properties";
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static Config config = new Config(LOGFILE);
	public int readInt(){
		try{
			config.init();
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		} catch (Exception e){
			LOGGER.error("INPUT_ERROR");
			return 0;
		}
	}
	
	public String readStrin(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public Date readDate(){
		try {
			config.init();
			Scanner sc = new Scanner(System.in);
			Date date = null;
			date = sdf.parse(sc.nextLine());
			return date;
		} catch (Exception e) {
			LOGGER.error("INPUT_ERROR");
			return null;
		}
		
	}
	
	public void print(String str){
		System.out.println(str);
	}
}
