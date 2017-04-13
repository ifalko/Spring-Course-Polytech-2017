package ru.spbpu.ics.dao.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("ru.spbpu.ics.dao.impls")
@PropertySource("classpath:db.properties")
public class SqlConfig {

	@Autowired
	private Environment env;

	@Bean
	public JdbcTemplate createjJdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource(){
		return new DriverManagerDataSource() {
			{
				setDriverClassName(env.getProperty("db.driver"));
				setUrl(env.getProperty("db.url"));
				setUsername(env.getProperty("db.username"));
				setPassword(env.getProperty("db.password"));
			}
		};
	}

}
