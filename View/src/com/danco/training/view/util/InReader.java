package com.danco.training.view.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class InReader {
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static int readInt(){
		int i;
		Scanner sc = new Scanner(System.in);
		try{
			i = sc.nextInt();
			return i;
		} catch (Exception e){
			LOGGER.error(e.getMessage(),e);
			return 0;
		}
	}
	
	public static String readStrin(){
		String str;
		Scanner sc = new Scanner(System.in);
		try{
			str = sc.nextLine();
			return str;
		}
		 catch (Exception e){
			LOGGER.error(e.getMessage(),e);
			return null;
		}
	}
	
	public static Date readDate(){
		Scanner sc = new Scanner(System.in);
		Date date = null;
		try {
			date = sdf.parse(sc.nextLine());
			return date;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			return null;
		}
	}
	
	public static boolean readBoolean(){
		Scanner sc = new Scanner(System.in);
		Boolean bool = null;
		try {
			bool = sc.nextBoolean();
			return bool;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			return false;
		}
	}
	
	public static void print(String str){
		System.out.println(str);
	}
	public static void print(){
		System.out.println();
	}
}
