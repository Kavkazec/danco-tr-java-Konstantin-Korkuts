package com.danco.ems.start;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.danco.ems.service.impl")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.danco.ems.repository"})
public class Config {



	/**
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ems");
		dataSource.setUsername("root");
		dataSource.setPassword("d3dwq7zs");
		return dataSource;
	}

	/**
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaProperties(createJpaProperties());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.danco.ems.entity");
		return entityManagerFactoryBean;
	}

	/**
	 * @return Properties
	 */
	private Properties createJpaProperties()
	{
		Properties result = new Properties();
		result.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return result;
	}

	/**
	 * @param entityManagerFactory
	 * @return JpaTransactionManager
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	/**
	 * @return PropertySourcesPlaceholderConfigurer
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
}
