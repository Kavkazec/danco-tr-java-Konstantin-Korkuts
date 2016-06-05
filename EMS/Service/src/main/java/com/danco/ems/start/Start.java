package com.danco.ems.start;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danco.ems.entity.Book;
import com.danco.ems.properties.repository.ApplicationConfiguration;
import com.danco.ems.service.BookServiceImpl;

public class Start {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		BookServiceImpl service = ctx.getBean(BookServiceImpl.class);
		
	}

}
