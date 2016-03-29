package com.danco.training.view.util;

import java.util.List;

public class PrintString {
	public static void printString(List<String> list){
		for (String string : list) {
			InReader.print(string);
		}
	}
}
