package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.cognizant")
@PropertySource(value= {"classpath:db.properties"})
public class AppConfig {
	@Autowired
	private Environment env;
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName(env.getRequiredProperty("driver"));
		db.setUrl(env.getRequiredProperty("url"));
		db.setUsername(env.getRequiredProperty("user"));
		db.setPassword(env.getRequiredProperty("password"));
		return db;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate(dataSource());
		return jt;
	}
	

	
}