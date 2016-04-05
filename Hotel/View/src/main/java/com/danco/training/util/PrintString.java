package com.danco.training.util;

import java.util.List;

public class PrintString {
	public static void printString(List<String> list){
		for (String string : list) {
			InReader.print(string);
		}
	}
}
