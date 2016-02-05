package com.danco.training.controller.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class InReader {
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public int readInt(){
		int i;
		Scanner sc = new Scanner(System.in);
		try{
			i = sc.nextInt();
			return i;
		} catch (Exception e){
			LOGGER.error("INPUT_ERROR");
			return 0;
		}
	}
	
	public String readStrin(){
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		return str;
	}
	
	public Date readDate(){
		Scanner sc = new Scanner(System.in);
		Date date = null;
		try {
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
	public void print(){
		System.out.println();
	}
}
