package com.danco.ems.properties.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.danco.ems.properties.database.DatabaseConfig;

@Configuration
@ComponentScan("com.danco.ems.service")
@Import({ DatabaseConfig.class})
public class ApplicationConfiguration {

}
