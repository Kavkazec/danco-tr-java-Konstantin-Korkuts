package com.danco.training.main;

import com.danco.training.annotation.ProcessAnnotation;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.properties.init.annotation.InitServerAnnotation;

public class Test {
	public static void main(String[] args) {
		PropertiesReader.getInstance().setProperties();
		ProcessAnnotation p = new ProcessAnnotation();
		InitServerAnnotation s = new InitServerAnnotation();
		p.procAnnotation(s);
		System.out.println(s.buildServices().size());
		for(int i = 0; i < s.buildServices().size(); i++){
			System.out.println(s.buildServices().get(i).getName());
		}
	}
}
