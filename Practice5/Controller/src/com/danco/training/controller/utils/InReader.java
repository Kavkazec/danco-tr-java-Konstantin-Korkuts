package com.danco.training.controller.utils;

import java.util.Scanner;

public class InReader {
	public int readInt(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public String readStrin(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void print(String str){
		System.out.println(str);
	}
}
