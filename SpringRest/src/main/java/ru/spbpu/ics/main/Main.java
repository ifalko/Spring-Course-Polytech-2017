package ru.spbpu.ics.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication(scanBasePackages={"ru.spbpu.ics.controls", "ru.spbpu.ics.impls"})
@PropertySource("classpath:db.properties")
public class Main {

	@Autowired
	private Environment env;

	@Bean
	public JdbcTemplate createjJdbcTemplate(DataSource dataSource){
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
	
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
